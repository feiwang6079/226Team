//  SJSU CMPE 226 Spring 2019 TEAM One.
//  Drink.h
//  Cafe
//
//  Created by fei wang on 2019/5/1.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Drink : NSObject

@property(nonatomic, strong) NSString *ice_level;
@property(nonatomic, strong) NSString *sugar_level;
@property(nonatomic, strong) NSString *tea_name;
@property(nonatomic, assign) double price;
@property(nonatomic, strong) NSString *topping;


@end

NS_ASSUME_NONNULL_END
