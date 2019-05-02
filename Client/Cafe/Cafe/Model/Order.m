//
//  Order.m
//  Cafe
//
//  Created by fei wang on 2019/5/1.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "Order.h"

@implementation Order

+ (NSDictionary *)modelContainerPropertyGenericClass {
    return @{@"drinks" : [Drink class]};
}

@end
