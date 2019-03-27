//
//  PublicMethod.m
//  Cafe
//
//  Created by fei wang on 2019/3/22.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "PublicMethod.h"

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

@end
