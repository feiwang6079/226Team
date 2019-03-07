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

@interface HomeViewController ()<UITableViewDataSource, UITableViewDelegate>

@property (weak, nonatomic) IBOutlet UITableView *myTableView;

@property(strong, nonatomic) NSMutableArray *drinkArray;

@end

@implementation HomeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"Drinks";
    
    UIButton *rightButton = [UIButton buttonWithType:UIButtonTypeCustom];
    rightButton.frame = CGRectMake(0, 0, 25, 17);
    [rightButton setBackgroundImage:[UIImage imageNamed:@"icon_homepage_map_selected_old"] forState:UIControlStateNormal];
    [rightButton addTarget:self action:@selector(showCafeButtonPressed) forControlEvents:UIControlEventTouchUpInside];
    UIBarButtonItem *rightItem = [[UIBarButtonItem alloc] initWithCustomView:rightButton];
//    [self.navigationController.navigationBar.view
    self.navigationItem.rightBarButtonItem = rightItem;
    
    
    _drinkArray = [NSMutableArray arrayWithObjects:@"drink1",@"drink1",@"drink1",@"drink1",@"drink1", nil];
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
    return cell;
}

-(void)showCafeButtonPressed{
    NSLog(@"button pressed");
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    SelectViewController *svc = [[SelectViewController alloc] init];
    [self.navigationController pushViewController:svc animated:YES];
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
