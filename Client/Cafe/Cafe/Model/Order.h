//
//  Order.h
//  Cafe
//
//  Created by fei wang on 2019/5/1.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Drink.h"

NS_ASSUME_NONNULL_BEGIN

@interface Order : NSObject

//[{"order_id":34,"total_price":1.2,"status":"unpaid","t":"23:32:04","cus_id":12345,"re_id":"cafe_01","drinks":[{"drink_id":57,"ice_level":"0%","sugar_level":"0%","price":1.2,"emp_id":"emp_01","tea_name":"Oolong","topping":null}]},{"order_id":35,"total_price":1.2,"status":"unpaid","t":"23:33:35","cus_id":12345,"re_id":"cafe_01","drinks":[{"drink_id":58,"ice_level":"0%","sugar_level":"0%","price":1.2,"emp_id":"emp_01","tea_name":"Oolong","topping":null}]}]"

@property(nonatomic, assign) double order_id;
@property(nonatomic, assign) double total_price;
@property(nonatomic, strong) NSString *status;
@property(nonatomic, strong) NSArray *drinks;

@end

NS_ASSUME_NONNULL_END
