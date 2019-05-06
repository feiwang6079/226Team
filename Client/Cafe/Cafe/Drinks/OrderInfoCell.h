//  SJSU CMPE 226 Spring 2019 TEAM One.
//  OrderInfoCell.h
//  Cafe
//
//  Created by fei wang on 2019/3/9.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface OrderInfoCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UILabel *titleLable;

@property (weak, nonatomic) IBOutlet UILabel *levelLabel;

@property (weak, nonatomic) IBOutlet UILabel *toppoingLabel;

@property (weak, nonatomic) IBOutlet UILabel *priceLabel;

@end

NS_ASSUME_NONNULL_END
