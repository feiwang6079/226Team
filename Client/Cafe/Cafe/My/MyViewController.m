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

@interface MyViewController ()

@property (weak, nonatomic) IBOutlet UILabel *moneyLabel;


@end

@implementation MyViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"My";
}

- (IBAction)addButtonPressed:(id)sender {
    
    [[NetworkManager sharedNetworkManager] getWithUrlString:[NSString stringWithFormat:@"%@users",URL] parameters:@"" success:^(id response){
        NSLog(@"%@", response);

        
//        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
//        if(result.code != 200){
//            [SVProgressHUD showErrorWithStatus:result.message];
//        }else{
//            NSUserDefaults *user = [NSUserDefaults standardUserDefaults];
//            [user setObject:result.data forKey:USERTOKEN];
//            [user synchronize];
//
//            NSNotification *notification = [NSNotification notificationWithName:LOGINSUCCESS object:nil];
//            [[NSNotificationCenter defaultCenter] postNotification:notification];
//        }
        
        

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
