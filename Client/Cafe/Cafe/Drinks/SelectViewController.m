//
//  SelectViewController.m
//  Cafe
//
//  Created by fei wang on 2019/3/6.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "SelectViewController.h"
#import "SelectCell.h"

@interface SelectViewController ()<UITableViewDataSource, UITableViewDelegate>

@property (weak, nonatomic) IBOutlet UITableView *myTableView;


@end

@implementation SelectViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.tabBarController.tabBar.hidden = YES;
    
    self.title = @"Topping";
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 3;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return 3;
}

- (nullable NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    if(section == 0){
        return @"Select Size";
    }else if(section == 1){
        return @"Select sugar";
    }else{
        return @"Select Toppings";
    }
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    SelectCell *cell = [tableView dequeueReusableCellWithIdentifier:@"selectCell"];
    if(cell == nil){
        cell = [[[NSBundle mainBundle] loadNibNamed:@"SelectCell" owner:self options:nil] lastObject];
    }
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
