//
//  NetworkManager.h
//  Cafe
//
//  Created by fei wang on 2019/3/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AFHTTPSessionManager.h"


NS_ASSUME_NONNULL_BEGIN

//宏定义成功block 回调成功后得到的信息
typedef void (^HttpSuccess)(id data);
//宏定义失败block 回调失败信息
typedef void (^HttpFailure)(NSError *error);

@interface NetworkManager : NSObject
{
    AFHTTPSessionManager *afManager;
}
    
+ (NetworkManager *)sharedNetworkManager;
    
-(void)getWithUrlString:(NSString *)urlString parameters:(NSDictionary *)parameters success:(HttpSuccess)success failure:(HttpFailure)failure;
    
-(void)postWithUrlString:(NSString *)urlString parameters:(NSDictionary *)parameters success:(HttpSuccess)success failure:(HttpFailure)failure;

@end

NS_ASSUME_NONNULL_END
