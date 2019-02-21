//
//  LoginViewController.m
//  Cafe
//
//  Created by fei wang on 2019/2/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "LoginViewController.h"
#import "SVProgressHUD.h"

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



/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
