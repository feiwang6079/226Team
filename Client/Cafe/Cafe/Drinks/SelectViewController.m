//
//  SelectViewController.m
//  Cafe
//
//  Created by fei wang on 2019/3/6.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "SelectViewController.h"
#import "SelectCell.h"
#import "ConfirmOrderVController.h"
#import "HomeViewController.h"

@interface SelectViewController ()<UITableViewDataSource, UITableViewDelegate>

@property (weak, nonatomic) IBOutlet UITableView *myTableView;

@property (strong, nonatomic) NSMutableDictionary *rowDic;
@property (strong, nonatomic) NSMutableDictionary *selectDic;

@property (strong, nonatomic) NSMutableArray *selectArray;


@end

@implementation SelectViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.tabBarController.tabBar.hidden = YES;
    
    self.title = @"Topping";
    
    _selectArray = [NSMutableArray arrayWithObjects:@"Select Size", @"Select sugar", @"Select Toppings", nil];
    _rowDic = [NSMutableDictionary dictionary];
    [_rowDic setObject:@[@"Large",@"Mid",@"Small"] forKey:[_selectArray objectAtIndex:0]];
    [_rowDic setObject:@[@"Large",@"Mid",@"Small"] forKey:[_selectArray objectAtIndex:1]];
    [_rowDic setObject:@[@"Large",@"Mid",@"Small"] forKey:[_selectArray objectAtIndex:2]];
    _selectDic = [NSMutableDictionary dictionary];
    [_selectDic setValue:@"0" forKey:[_selectArray objectAtIndex:0]];
    [_selectDic setValue:@"0" forKey:[_selectArray objectAtIndex:1]];
    [_selectDic setValue:@"0" forKey:[_selectArray objectAtIndex:2]];
    
//    UIButton *rightButton = [UIButton buttonWithType:UIButtonTypeCustom];
//    rightButton.frame = CGRectMake(0, 0, 25, 17);
//    [rightButton setBackgroundImage:[UIImage imageNamed:@"icon_homepage_map_selected_old"] forState:UIControlStateNormal];
//    [rightButton addTarget:self action:@selector(showCafeButtonPressed) forControlEvents:UIControlEventTouchUpInside];
//    UIBarButtonItem *rightItem = [[UIBarButtonItem alloc] initWithCustomView:rightButton];
//    //    [self.navigationController.navigationBar.view
//    self.navigationItem.rightBarButtonItem = rightItem;
    
    UIBarButtonItem *rightitem = [[UIBarButtonItem alloc] initWithTitle:@"确定" style:UIBarButtonItemStyleDone target:self action:@selector(sureButtonPressed)];
    self.navigationItem.rightBarButtonItem = rightitem;
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return [_selectArray count];
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [[_rowDic objectForKey:[_selectArray objectAtIndex:section]] count];
}

- (nullable NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    return [_selectArray objectAtIndex:section];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    SelectCell *cell = [tableView dequeueReusableCellWithIdentifier:@"selectCell"];
    if(cell == nil){
        cell = [[[NSBundle mainBundle] loadNibNamed:@"SelectCell" owner:self options:nil] lastObject];
        cell.selectionStyle = UITableViewCellSelectionStyleNone;
    }
    NSString *key = [_selectArray objectAtIndex:indexPath.section];
    NSString *title = [[_rowDic objectForKey:key] objectAtIndex:indexPath.row];
    cell.selectLabel.text = title;
    if(indexPath.row == [[_selectDic objectForKey:key] intValue]){
        cell.selectImage.image = [UIImage imageNamed:@"WX20190306-193015.png"];
    }else{
        cell.selectImage.image = [UIImage imageNamed:@"WX20190306-193048.png"];
    }
    
    return cell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    NSString *key = [_selectArray objectAtIndex:indexPath.section];
    int row = [[_selectDic objectForKey:key] intValue];
    if(row != indexPath.row){
        [_selectDic setValue:[NSString stringWithFormat:@"%lu", indexPath.row] forKey:[_selectArray objectAtIndex:indexPath.section]];
        [tableView reloadData];
    }
}

-(void)sureButtonPressed{
    //UIAlertController风格：UIAlertControllerStyleAlert
    UIAlertController *alertController = [UIAlertController alertControllerWithTitle:@"是否还要其他的饮料"
                                                                             message:nil
                                                                      preferredStyle:UIAlertControllerStyleAlert];
    
    //添加取消到UIAlertController中
    UIAlertAction *cancelAction = [UIAlertAction actionWithTitle:@"取消" style:UIAlertActionStyleDefault handler:^(UIAlertAction * _Nonnull action) {
//        NSLog(@"点击了完成按钮");
        
        ConfirmOrderVController *svc = [[ConfirmOrderVController alloc] init];
        [self.navigationController pushViewController:svc animated:YES];
        
    }];
    [alertController addAction:cancelAction];
    
    //添加确定到UIAlertController中
    UIAlertAction *OKAction = [UIAlertAction actionWithTitle:@"确定" style:UIAlertActionStyleDefault handler:^(UIAlertAction * _Nonnull action) {
//        NSLog(@"点击了完成按钮");
        HomeViewController *svc = [[HomeViewController alloc] init];
        svc.isSecondIncome = YES;
        [self.navigationController pushViewController:svc animated:YES];
    }];
    [alertController addAction:OKAction];
    
    [self presentViewController:alertController animated:YES completion:nil];
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
