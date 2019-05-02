//
//  ConfirmOrderVController.m
//  Cafe
//
//  Created by fei wang on 2019/3/9.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "ConfirmOrderVController.h"
#import "OrderInfoCell.h"
#import "SubmitCell.h"
#import "SVProgressHUD.h"
#import "NetworkManager.h"
#import "ServerResult.h"
#import "YYModel.h"

@interface ConfirmOrderVController ()<UITableViewDelegate, UITableViewDataSource, SubmitCellDelegate>

@property (weak, nonatomic) IBOutlet UITableView *myTableView;

@property(assign, nonatomic) double total;

@end

@implementation ConfirmOrderVController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"Order Detail";
    
    for(int i = 0; i < self.drinkArray.count; i++){
        Drink *dri = [self.drinkArray objectAtIndex:i];
        self.total += dri.price;
    }
}


-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 2;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    if(section == 0){
        return [self.drinkArray count];
    }else{
        return 1;
    }
}

-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath{
    if(indexPath.row == 0){
        return 81;
    }else{
        return 74;
    }
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    if(indexPath.section == 0){
        OrderInfoCell *cell = [tableView dequeueReusableCellWithIdentifier:@"orderCell"];
        if(cell == nil){
            cell = [[[NSBundle mainBundle] loadNibNamed:@"OrderInfoCell" owner:self options:nil] lastObject];
            cell.selectionStyle = UITableViewCellSelectionStyleNone;
        }
        Drink *aDrink = [self.drinkArray objectAtIndex:indexPath.row];
        cell.titleLable.text = aDrink.tea_name;
        cell.levelLabel.text = [NSString stringWithFormat:@"ice level: %@ sugar level: %@", aDrink.ice_level, aDrink.sugar_level];
        cell.toppoingLabel.text = [NSString stringWithFormat:@"Topping: %@", aDrink.topping?aDrink.topping:@"Nothing"];
        cell.priceLabel.text = [NSString stringWithFormat:@"%.1f", aDrink.price];
        
        return cell;
    }else{
        SubmitCell *cell = [tableView dequeueReusableCellWithIdentifier:@"submitCell"];
        if(cell == nil){
            cell = [[[NSBundle mainBundle] loadNibNamed:@"SubmitCell" owner:self options:nil] lastObject];
            cell.selectionStyle = UITableViewCellSelectionStyleNone;
        }
        [cell.submitButton setTitle:[NSString stringWithFormat:@"$%.1f Submit Order", self.total] forState:UIControlStateNormal];
        cell.delegate = self;
        return cell;
    }
}

-(void)submitPressed{
    
    [SVProgressHUD showWithStatus:@"Please wait"];
    
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    NSMutableDictionary *dic = [NSMutableDictionary dictionary];
    [dic setValue:[userDefaults valueForKey:USERTOKEN] forKey:@"cus_id"];
    [dic setValue:[userDefaults valueForKey:USER_RE] forKey:@"re_id"];
    [dic setObject:[NSNumber numberWithDouble:self.total] forKey:@"total_price"];
    
    NSMutableArray *array = [NSMutableArray array];
    for(Drink *aDri in self.drinkArray){
        NSDictionary *dic = [aDri yy_modelToJSONObject];
        [array addObject:dic];
    }
    [dic setObject:array forKey:@"drinks"];

    [[NetworkManager sharedNetworkManager] postWithUrlString:[NSString stringWithFormat:@"%@orders",URL] parameters:dic success:^(id response){
        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
        if(result.code != 200){
            [SVProgressHUD showErrorWithStatus:result.message];
        }else{
            [SVProgressHUD dismiss];
            [self.navigationController popToRootViewControllerAnimated:YES];
        }
    } failure:^(NSError *error){
        NSLog(@"%@", error);
        [SVProgressHUD showErrorWithStatus: error.localizedDescription];
    }];
    
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
