//
//  PublicMethod.m
//  Cafe
//
//  Created by fei wang on 2019/3/22.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "PublicMethod.h"
#import <CommonCrypto/CommonDigest.h>

//秘钥
static NSString *encryptionKey = @"nha735n197nxn(N′568GGS%d~~9naei';45vhhafdjkv]32rpks;lg,];:vjo(&**&^)";


@implementation PublicMethod

+(BOOL) isiPhoneX {
    // iPhone X/XS 375 812 (@3x)
    // iPhone XS Max 414 896 (@3x)
    // iPhone XR     414 896 (@2x)
    

    CGFloat screentHeight = [UIScreen mainScreen].bounds.size.height;
    if(screentHeight == 812.0f || screentHeight == 896.0f){
        return YES;
    }
    return NO;
}

+ (NSString *)md5EncryptWithString:(NSString *)string{
//    return [self md5:[NSString stringWithFormat:@"%@%@", encryptionKey, string]];
    return [self md5:string];

}

+ (NSString *)md5:(NSString *)string{
    const char *cStr = [string UTF8String];
    unsigned char digest[CC_MD5_DIGEST_LENGTH];
    
    CC_MD5(cStr, (CC_LONG)strlen(cStr), digest);
    
    NSMutableString *result = [NSMutableString stringWithCapacity:CC_MD5_DIGEST_LENGTH * 2];
    for (int i = 0; i < CC_MD5_DIGEST_LENGTH; i++) {
        [result appendFormat:@"%02X", digest[i]];
    }
    
    return result;
}

@end
