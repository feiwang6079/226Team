//
//  AddressViewController.m
//  Cafe
//
//  Created by fei wang on 2019/3/15.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "AddressViewController.h"
#import "AddressCell.h"
#import "NetworkManager.h"
#import "SVProgressHUD.h"
#import "YYModel.h"
#import "Address.h"
#import "ServerResult.h"


@interface AddressViewController ()<UITableViewDataSource, UITableViewDelegate>

@property (weak, nonatomic) IBOutlet UITableView *myTableView;

@property (nonatomic, strong) NSArray *locationArray;


@end

@implementation AddressViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"Address";
    self.tabBarController.tabBar.hidden = YES;
    _locationArray = [NSArray array];
    
    [SVProgressHUD showWithStatus:@"Please wait"];
    [[NetworkManager sharedNetworkManager] getWithUrlString:[NSString stringWithFormat:@"%@cafe",URL] parameters:[NSDictionary dictionary] success:^(id response){
        ServerResult *result = [ServerResult yy_modelWithDictionary:response];
        if(result.code != 200){
            [SVProgressHUD showErrorWithStatus:result.message];
        }else{
            [SVProgressHUD dismiss];
            NSArray *arr = [NSArray yy_modelArrayWithClass:[Address class] json:result.data];
            self.locationArray = arr;
            [self.myTableView reloadData];
        }
    } failure:^(NSError *error){
        NSLog(@"%@", error);
        [SVProgressHUD showErrorWithStatus: error.localizedDescription];
    }];
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [_locationArray count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    AddressCell *cell = [tableView dequeueReusableCellWithIdentifier:@"addressCell"];
    if(cell == nil){
        cell = [[[NSBundle mainBundle] loadNibNamed:@"AddressCell" owner:self options:nil] lastObject];
    }
    Address *address = [self.locationArray objectAtIndex:indexPath.row];
    cell.regLabel.text = [NSString stringWithFormat:@"%@", address.re_id];
    cell.locationLabel.text = [NSString stringWithFormat:@"%@", address.location];
    return cell;
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
