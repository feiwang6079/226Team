//
//  HomeViewController.h
//  Cafe
//
//  Created by fei wang on 2019/2/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface HomeViewController : UIViewController

@property(assign, nonatomic) Boolean isSecondIncome;

@property(strong, nonatomic) NSMutableArray *orderArray;

@end

NS_ASSUME_NONNULL_END
