//
//  ConfirmOrderVController.h
//  Cafe
//
//  Created by fei wang on 2019/3/9.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Drink.h"

NS_ASSUME_NONNULL_BEGIN

@interface ConfirmOrderVController : UIViewController

@property(strong, nonatomic)NSArray *drinkArray;

@property(strong, nonatomic)Drink *drinkDetail;

@end

NS_ASSUME_NONNULL_END
