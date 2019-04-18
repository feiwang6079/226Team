//
//  PublicMethod.h
//  Cafe
//
//  Created by fei wang on 2019/3/22.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface PublicMethod : NSObject

//md5加密方法
+ (NSString *)md5EncryptWithString:(NSString *)string;

@end

NS_ASSUME_NONNULL_END
