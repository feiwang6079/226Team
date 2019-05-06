//  SJSU CMPE 226 Spring 2019 TEAM One.
//  SelectViewController.h
//  Cafe
//
//  Created by fei wang on 2019/3/6.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface SelectViewController : UIViewController

@property(strong, nonatomic) NSString *tea_name;

@property(strong, nonatomic) NSMutableArray *orderArray;

@end

NS_ASSUME_NONNULL_END
