//  SJSU CMPE 226 Spring 2019 TEAM One.
//  OrderCell.h
//  Cafe
//
//  Created by fei wang on 2019/3/15.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface OrderCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UILabel *orderInfoLabel;

@property (weak, nonatomic) IBOutlet UILabel *totalPriceLabel;

@property (weak, nonatomic) IBOutlet UIButton *payButton;

@end

NS_ASSUME_NONNULL_END
