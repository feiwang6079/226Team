//  SJSU CMPE 226 Spring 2019 TEAM One.
//  Customer.h
//  Cafe
//
//  Created by fei wang on 2019/4/17.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Customer : NSObject

@property (nonatomic, assign) NSInteger cus_id;
@property (nonatomic, strong) NSString *password;
@property (nonatomic, assign) NSInteger points;
@property (nonatomic, assign) double account_balance;

@end

NS_ASSUME_NONNULL_END
