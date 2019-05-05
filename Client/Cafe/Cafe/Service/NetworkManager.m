//
//  NetworkManager.m
//  Cafe
//
//  Created by fei wang on 2019/3/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "NetworkManager.h"

@implementation NetworkManager
    
    
+ (NetworkManager *)sharedNetworkManager{
    
    static dispatch_once_t onceToken;
    static NetworkManager *manager;
    dispatch_once(&onceToken, ^{
        manager = [[NetworkManager alloc] init];
    });
    
    return manager;
}
    
- (instancetype)init{
    if (self = [super init]) {
        afManager = [AFHTTPSessionManager manager];
        afManager.responseSerializer.acceptableContentTypes = [NSSet setWithObjects:@"application/json",@"text/json",@"text/javascript",@"text/html", nil];
        afManager.requestSerializer = [AFJSONRequestSerializer serializer];
//        afManager.responseSerializer = [AFJSONResponseSerializer serializer];

    }
    return self;
}
    
    
//+ (id)allocWithZone:(NSZone *)zone {
//    NSString *reason = [NSString stringWithFormat:@"Attempt to allocate a second instance of the singleton %@", [self class]];
//    NSException *exception = [NSException exceptionWithName:@"Multiple singletons" reason:reason userInfo:nil];
//    [exception raise];
//    return nil;
//}
    
-(void)getWithUrlString:(NSString *)urlString parameters:(NSDictionary *)parameters success:(HttpSuccess)success failure:(HttpFailure)failure{

    [afManager GET:urlString parameters:parameters progress:^(NSProgress * _Nonnull downloadProgress) {
        //数据请求的进度
    } success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        success(responseObject);
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        failure(error);
    }];
}
    
-(void)postWithUrlString:(NSString *)urlString parameters:(NSDictionary *)parameters success:(HttpSuccess)success failure:(HttpFailure)failure{
    //post请求
    [afManager POST:urlString parameters:parameters progress:^(NSProgress * _Nonnull uploadProgress) {
        //数据请求的进度
    } success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        success(responseObject);
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        failure(error);
    }];
}

@end
