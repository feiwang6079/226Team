//
//  SubmitCell.m
//  Cafe
//
//  Created by fei wang on 2019/3/15.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "SubmitCell.h"

@implementation SubmitCell

- (void)awakeFromNib {
    [super awakeFromNib];
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

- (IBAction)submitButtonPressed:(id)sender {
    if(self.delegate){
        [self.delegate submitPressed];
    }
}


@end
