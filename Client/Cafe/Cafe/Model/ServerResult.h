//  SJSU CMPE 226 Spring 2019 TEAM One.

//  ServerResult.h
//  Cafe
//
//  Created by fei wang on 2019/4/17.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface ServerResult : NSObject

@property (nonatomic, assign) NSInteger code;
@property (nonatomic, strong) NSString *message;
@property (nonatomic, strong) NSString *data;

@end

NS_ASSUME_NONNULL_END
