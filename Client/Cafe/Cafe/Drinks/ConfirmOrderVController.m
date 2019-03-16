//
//  ConfirmOrderVController.m
//  Cafe
//
//  Created by fei wang on 2019/3/9.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "ConfirmOrderVController.h"
#import "OrderInfoCell.h"
#import "SubmitCell.h"

@interface ConfirmOrderVController ()<UITableViewDelegate, UITableViewDataSource, SubmitCellDelegate>

@property (weak, nonatomic) IBOutlet UITableView *myTableView;


@end

@implementation ConfirmOrderVController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"Order Detail";
}


-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 2;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    if(section == 0){
        return 2;
    }else{
        return 1;
    }
}

-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath{
    if(indexPath.row == 0){
        return 81;
    }else{
        return 74;
    }
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    if(indexPath.section == 0){
        OrderInfoCell *cell = [tableView dequeueReusableCellWithIdentifier:@"orderCell"];
        if(cell == nil){
            cell = [[[NSBundle mainBundle] loadNibNamed:@"OrderInfoCell" owner:self options:nil] lastObject];
            cell.selectionStyle = UITableViewCellSelectionStyleNone;
        }
        return cell;
    }else{
        SubmitCell *cell = [tableView dequeueReusableCellWithIdentifier:@"submitCell"];
        if(cell == nil){
            cell = [[[NSBundle mainBundle] loadNibNamed:@"SubmitCell" owner:self options:nil] lastObject];
            cell.selectionStyle = UITableViewCellSelectionStyleNone;
        }
        cell.delegate = self;
        return cell;
    }
}

-(void)submitPressed{
    
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
