//
//  User.h
//  Cafe
//
//  Created by fei wang on 2019/3/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface User : NSObject
    

@property (nonatomic, strong) NSString *q;
@property (nonatomic, strong) NSString *username;
@property (nonatomic, assign) NSString *password;
    
//    // 将 JSON (NSData,NSString,NSDictionary) 转换为 Model:
//    User *user = [User yy_modelWithJSON:json];
   
//    // 将 Model 转换为 JSON 对象:
//    NSDictionary *json = [user yy_modelToJSONObject];

@end

NS_ASSUME_NONNULL_END
