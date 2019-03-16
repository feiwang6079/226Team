//
//  SubmitCell.h
//  Cafe
//
//  Created by fei wang on 2019/3/15.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import <UIKit/UIKit.h>

@protocol SubmitCellDelegate <NSObject>
@required
- (void) submitPressed;
@end

NS_ASSUME_NONNULL_BEGIN

@interface SubmitCell : UITableViewCell

@property(nonatomic, assign) id<SubmitCellDelegate>delegate;

@end

NS_ASSUME_NONNULL_END
