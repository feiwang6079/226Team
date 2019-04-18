//
//  DrinkTableViewCell.h
//  Cafe
//
//  Created by fei wang on 2019/3/6.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface DrinkTableViewCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UILabel *nameLable;

@property (weak, nonatomic) IBOutlet UILabel *priceLabel;

@end

NS_ASSUME_NONNULL_END
