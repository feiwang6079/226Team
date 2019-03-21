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
#import "User.h"

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
        
    }

    
    return YES;

}
    
- (IBAction)loginButtonPressed:(id)sender {
    NSDictionary * dic = [NSDictionary dictionaryWithObjectsAndKeys:@"login" ,@"q",
                          @"user1", @"username",
                          @"pass1", @"password", nil];
    
    
    User *user = [User yy_modelWithDictionary:dic];
    NSLog(@"%@", user);
/*
    [[NetworkManager sharedNetworkManager] getWithUrlString:@"http://172.20.10.8:8080/users" parameters:dic success:^(id response){
        NSLog(@"%@", response);
    } failure:^(NSError *error){
        NSLog(@"%@", error);
    }];
 */
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
