//
//  LoginViewController.m
//  Cafe
//
//  Created by fei wang on 2019/2/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "LoginViewController.h"
#import "SVProgressHUD.h"
#import "AFURLSessionManager.h"
#import "AFHTTPSessionManager.h"
#import "NetworkManager.h"
#import "YYModel.h"
#import "ServerResult.h"

@interface LoginViewController ()<UITextFieldDelegate>

@end

@implementation LoginViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField
{
    if(textField == self.accountTextField){
        [self.passwordTextField becomeFirstResponder];
    }
    else{
//        NSLog(@"123123");
        [self loginButtonPressed:nil];
    }

    
    return YES;

}
    
- (IBAction)loginButtonPressed:(id)sender {
    
//    NSString *userName = self.accountTextField.text;
//    NSString *password = self.passwordTextField.text;
//    if(userName == nil || password == nil || [userName isEqualToString:@""] || [password isEqualToString:@""]){
//        [SVProgressHUD showErrorWithStatus:@"Please input all information"];
//        return;
//    }
//
//    password = [PublicMethod md5EncryptWithString:password];
//
//    NSDictionary * dic = [NSDictionary dictionaryWithObjectsAndKeys:@"login" ,@"q",
//                          userName, @"username",
//                          password, @"password", nil];
//
//    [[NetworkManager sharedNetworkManager] getWithUrlString:[NSString stringWithFormat:@"%@users",URL] parameters:dic success:^(id response){
//        NSLog(@"%@", response);
//
//        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
//        if(result.code != 200){
//            [SVProgressHUD showErrorWithStatus:result.message];
//        }else{
//            NSUserDefaults *user = [NSUserDefaults standardUserDefaults];
//            [user setObject:result.data forKey:USERTOKEN];
//            [user synchronize];
//
            NSNotification *notification = [NSNotification notificationWithName:LOGINSUCCESS object:nil];
            [[NSNotificationCenter defaultCenter] postNotification:notification];
//        }
//
//    } failure:^(NSError *error){
//        NSLog(@"%@", error);
//        [SVProgressHUD showErrorWithStatus: error.localizedDescription];
//    }];
 
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
