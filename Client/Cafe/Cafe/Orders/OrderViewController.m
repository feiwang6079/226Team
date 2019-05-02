//
//  OrderViewController.m
//  Cafe
//
//  Created by fei wang on 2019/3/15.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "OrderViewController.h"
#import "OrderCell.h"
#import "SVProgressHUD.h"
#import "NetworkManager.h"
#import "ServerResult.h"
#import "Drink.h"
#import "YYModel.h"
#import "Order.h"
#import "Drink.h"

@interface OrderViewController ()<UITableViewDataSource, UITableViewDelegate>

@property(nonatomic, strong) NSArray *orderArray;

@property (weak, nonatomic) IBOutlet UITableView *orderTableView;


@end

@implementation OrderViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"Orders";
    self.orderArray = [NSArray array];
}

-(void)viewWillAppear:(BOOL)animated{
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    NSMutableDictionary *dic = [NSMutableDictionary dictionary];
    [dic setValue:[userDefaults valueForKey:USERTOKEN] forKey:@"cus_id"];
    
    [SVProgressHUD showWithStatus:@"Please wait"];
    [[NetworkManager sharedNetworkManager] getWithUrlString:[NSString stringWithFormat:@"%@getorders",URL] parameters:dic success:^(id response){
        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
        if(result.code != 200){
            [SVProgressHUD showErrorWithStatus:result.message];
        }else{
            [SVProgressHUD dismiss];
            NSArray *arr = [NSArray yy_modelArrayWithClass:[Order class] json:result.data];
            self.orderArray = arr;
            [self.orderTableView reloadData];
        }
    } failure:^(NSError *error){
        NSLog(@"%@", error);
        [SVProgressHUD showErrorWithStatus: error.localizedDescription];
    }];
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [self.orderArray count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    OrderCell *cell = [tableView dequeueReusableCellWithIdentifier:@"orderCell"];
    if(cell == nil){
        cell = [[[NSBundle mainBundle] loadNibNamed:@"OrderCell" owner:self options:nil] lastObject];
        cell.selectionStyle = UITableViewCellSelectionStyleNone;
    }
    Order *order = [self.orderArray objectAtIndex:indexPath.row];
    NSMutableString *info = [NSMutableString string];
    for(Drink *drink in order.drinks){
        [info appendString:drink.tea_name];
        [info appendString:@" "];
    }
    cell.orderInfoLabel.text = info;
    cell.totalPriceLabel.text = [NSString stringWithFormat:@"%.1f", order.total_price];
    [cell.payButton setTitle:order.status forState:UIControlStateNormal];
    return cell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    Order *order = [self.orderArray objectAtIndex:indexPath.row];
    
    if([order.status isEqualToString:@"unpaid"]){
        
        //UIAlertController风格：UIAlertControllerStyleAlert
        UIAlertController *alertController = [UIAlertController alertControllerWithTitle:@"Pay"
                                                                                 message:nil
                                                                          preferredStyle:UIAlertControllerStyleAlert];
        
        //添加取消到UIAlertController中
        UIAlertAction *cancelAction = [UIAlertAction actionWithTitle:@"Cancel" style:UIAlertActionStyleDefault handler:^(UIAlertAction * _Nonnull action) {
        }];
        [alertController addAction:cancelAction];
        
        //添加确定到UIAlertController中
        UIAlertAction *OKAction = [UIAlertAction actionWithTitle:@"YES" style:UIAlertActionStyleDefault handler:^(UIAlertAction * _Nonnull action) {
            
            NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
            NSString *cus_id = [defaults valueForKey:USERTOKEN];
            
            NSMutableDictionary *dic = [NSMutableDictionary dictionary];
            [dic setValue:cus_id forKey:@"cus_id"];
            [dic setObject:[NSNumber numberWithDouble:order.order_id] forKey:@"order_id"];
            
            [SVProgressHUD showWithStatus:@"Please wait"];
            [[NetworkManager sharedNetworkManager] getWithUrlString:[NSString stringWithFormat:@"%@pay",URL] parameters:dic success:^(id response){
                NSLog(@"%@", response);
                
                ServerResult *result = [ServerResult yy_modelWithDictionary:response];
                if(result.code != 200){
                    [SVProgressHUD showErrorWithStatus:result.message];
                }else{
                    [SVProgressHUD dismiss];
                    order.status = @"paid";
                    [self.orderTableView reloadData];
                }
                
                
                
            } failure:^(NSError *error){
                NSLog(@"%@", error);
                [SVProgressHUD showErrorWithStatus: error.localizedDescription];
            }];
            
        }];
        [alertController addAction:OKAction];
        
        [self presentViewController:alertController animated:YES completion:nil];
        
        
    }else{
        
    }
}



/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
