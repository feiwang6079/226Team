//
//  MyViewController.m
//  Cafe
//
//  Created by fei wang on 2019/3/15.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "MyViewController.h"
#import "NetworkManager.h"
#import "SVProgressHUD.h"
#import "ServerResult.h"
#import "YYModel.h"

@interface MyViewController ()

@property (weak, nonatomic) IBOutlet UILabel *moneyLabel;

@property (assign, nonatomic) double money;

@end

@implementation MyViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"My";
    
//    NSUserDefaults *user = [NSUserDefaults standardUserDefaults];
//    double money = [user doubleForKey:USERMONEY];
//    self.moneyLabel.text = [NSString stringWithFormat:@"%.2f", money];
}

-(void)viewWillAppear:(BOOL)animated{
    
    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    NSString *user = [defaults valueForKey:USERTOKEN];
    NSDictionary *dic = [NSDictionary dictionaryWithObjectsAndKeys:user, @"cus_id", nil];
    
    [SVProgressHUD showWithStatus:@"Please wait"];

    [[NetworkManager sharedNetworkManager] postWithUrlString:[NSString stringWithFormat:@"%@getmoney",URL] parameters:dic success:^(id response){
        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
        if(result.code != 200){
            [SVProgressHUD showErrorWithStatus:result.message];
        }else{
            [SVProgressHUD dismiss];
            self.money = [result.data doubleValue];
            self.moneyLabel.text = [NSString stringWithFormat:@"%.2f", self.money];
        }
    } failure:^(NSError *error){
        NSLog(@"%@", error);
        [SVProgressHUD showErrorWithStatus: error.localizedDescription];
    }];
    
}

- (IBAction)addButtonPressed:(id)sender {
    
    NSUserDefaults *user = [NSUserDefaults standardUserDefaults];
    NSInteger cus_id = [user integerForKey:USERTOKEN];
    NSDictionary *dic = [NSDictionary dictionaryWithObjectsAndKeys:[NSNumber numberWithInteger:cus_id], @"cus_id", [NSNumber numberWithInteger:100], @"value", nil];
    [SVProgressHUD showWithStatus:@"Please wait!"];
    [[NetworkManager sharedNetworkManager] getWithUrlString:[NSString stringWithFormat:@"%@topup",URL] parameters:dic success:^(id response){
        NSLog(@"%@", response);

        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
        if(result.code != 200){
            [SVProgressHUD showErrorWithStatus:result.message];
        }else{
            [SVProgressHUD dismiss];
            self.money += 100;
            self.moneyLabel.text = [NSString stringWithFormat:@"%.2f", self.money];
//            NSUserDefaults *user = [NSUserDefaults standardUserDefaults];
//            double money = [user doubleForKey:USERMONEY];
//            money += 100;
//            self.moneyLabel.text = [NSString stringWithFormat:@"%.2f", money];
//            [user setDouble:money forKey:USERMONEY];
//            [user synchronize];
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
