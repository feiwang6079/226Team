//
//  HomeViewController.m
//  Cafe
//
//  Created by fei wang on 2019/2/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "HomeViewController.h"
#import "DrinkTableViewCell.h"
#import "SelectViewController.h"
#import "AddressViewController.h"
#import "NetworkManager.h"
#import "ServerResult.h"
#import "YYModel.h"
#import "SVProgressHUD.h"
#import "Tea.h"

@interface HomeViewController ()<UITableViewDataSource, UITableViewDelegate>

@property (weak, nonatomic) IBOutlet UITableView *myTableView;

@property(strong, nonatomic) NSArray *drinkArray;



@end

@implementation HomeViewController

-(void) viewWillAppear:(BOOL)animated{
    if(self.isSecondIncome){
        self.tabBarController.tabBar.hidden = YES;
    }else{
        self.tabBarController.tabBar.hidden = NO;
    }

}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"Teas";
    
    UIButton *rightButton = [UIButton buttonWithType:UIButtonTypeCustom];
    rightButton.frame = CGRectMake(0, 0, 25, 17);
    [rightButton setBackgroundImage:[UIImage imageNamed:@"icon_homepage_map_selected_old"] forState:UIControlStateNormal];
    [rightButton addTarget:self action:@selector(showCafeButtonPressed) forControlEvents:UIControlEventTouchUpInside];
    UIBarButtonItem *rightItem = [[UIBarButtonItem alloc] initWithCustomView:rightButton];
    self.navigationItem.rightBarButtonItem = rightItem;
    _drinkArray = [NSArray array];
    
    [SVProgressHUD showWithStatus:@"Please wait"];
    [[NetworkManager sharedNetworkManager] getWithUrlString:[NSString stringWithFormat:@"%@tea",URL] parameters:[NSDictionary dictionary] success:^(id response){
        NSLog(@"%@", response);
        
        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
        if(result.code != 200){
            [SVProgressHUD showErrorWithStatus:result.message];
        }else{
            [SVProgressHUD dismiss];
            NSArray *arr = [NSArray yy_modelArrayWithClass:[Tea class] json:result.data];
            self.drinkArray = arr;
            [self.myTableView reloadData];
        }
        
        
        
    } failure:^(NSError *error){
        NSLog(@"%@", error);
        [SVProgressHUD showErrorWithStatus: error.localizedDescription];
    }];
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [_drinkArray count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    DrinkTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"drinkCell"];
    if(cell == nil){
        cell = [[[NSBundle mainBundle] loadNibNamed:@"DrinkTableViewCell" owner:self options:nil] lastObject];
    }
    Tea *t = [self.drinkArray objectAtIndex:indexPath.row];
    cell.nameLable.text = t.tea_name;
    cell.priceLabel.text = [NSString stringWithFormat:@"$%0.2f", t.price];
    
    cell.teaImageView.image = [UIImage imageNamed:[NSString stringWithFormat:@"tea%ld.jpg", indexPath.row % 4 + 1]];
    
    return cell;
}

-(void)showCafeButtonPressed{
//    NSLog(@"button pressed");
    AddressViewController *svc = [[AddressViewController alloc] init];
    [self.navigationController pushViewController:svc animated:YES];
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    SelectViewController *svc = [[SelectViewController alloc] init];
    [self.navigationController pushViewController:svc animated:YES];
    [tableView deselectRowAtIndexPath:indexPath animated:FALSE];
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
