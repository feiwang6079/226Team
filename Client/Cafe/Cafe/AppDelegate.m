//
//  AppDelegate.m
//  Cafe
//
//  Created by fei wang on 2019/2/20.
//  Copyright © 2019 fei wang. All rights reserved.
//

#import "AppDelegate.h"
#import "LoginViewController.h"
#import "HomeViewController.h"
#import "MyTabViewController.h"

@interface AppDelegate (){
    MyTabViewController *tabBarController;
}



@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Override point for customization after application launch.
    
    self.window = [[UIWindow alloc]initWithFrame:[[UIScreen mainScreen]bounds]];
    LoginViewController *vc = [[LoginViewController alloc]init];
    [self.window setRootViewController:vc];
    self.window.backgroundColor = [UIColor whiteColor];
    [self.window makeKeyAndVisible];
    
    
    tabBarController = [[MyTabViewController alloc]  init];
//
//
//    [tabBarController setTabBarItem:[UITabBarItem initWithTitle:@"Home" image:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"] selectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"]]];
//       [tabBarController setTabBarItem:[UITabBarItem initWithTitle:@"Orders" image:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"] selectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"]]];
//       [tabBarController setTabBarItem:[UITabBarItem initWithTitle:@"My" image:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"] selectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"]]];
//
//        HomeViewController *hvc1 = [[HomeViewController alloc] init];
//        HomeViewController *hvc2 = [[HomeViewController alloc] init];
//        HomeViewController *hvc3 = [[HomeViewController alloc] init];
//        tabBarController.viewControllers = [NSArray arrayWithObjects:hvc1,hvc2,hvc3, nil];
    
//    UITabBar *tabBar =tabBarController.tabBar;
//    UITabBarItem *tabBarItem1 = [tabBar.items objectAtIndex:0];
//    UITabBarItem *tabBarItem2 = [tabBar.items objectAtIndex:1];
//    UITabBarItem *tabBarItem3 = [tabBar.items objectAtIndex:2];
//    tabBarItem1.title = @"Home";
//    tabBarItem2.title = @"Orders";
//    tabBarItem3.title = @"My";
//    tabBarItem1.image = [UIImage imageNamed:@"icon_tabbar_merchant_normal.png"];
////    tabBarItem1.selectedImage = [UIImage imageNamed:@"icon_tabbar_merchant_selected.png"];
//    tabBarItem2.image = [UIImage imageNamed:@"icon_tabbar_merchant_normal.png"];
//    tabBarItem2.selectedImage = [UIImage imageNamed:@"icon_tabbar_merchant_selected.png"];
//    tabBarItem3.image = [UIImage imageNamed:@"icon_tabbar_merchant_normal.png"];
//    tabBarItem3.selectedImage = [UIImage imageNamed:@"icon_tabbar_merchant_selected.png"];
    
//    tabBarItem1 = [UITabBar initWithTitle:@"Home" image:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"] selectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"]];
//    tabBarItem2 = [UITabBar initWithTitle:@"Orders" image:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"] selectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"]];
//    [tabBarItem3 initWithTitle:@"My" image:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"] selectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"]];
    
//    [tabBarItem1 setFinishedSelectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"] withFinishedUnselectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"]];
//    [tabBarItem2 setFinishedSelectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"] withFinishedUnselectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"]];
//    [tabBarItem3 setFinishedSelectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_selected.png"] withFinishedUnselectedImage:[UIImage imageNamed:@"icon_tabbar_merchant_normal.png"]];
    
    
    [self.window setRootViewController:tabBarController];

    
    
    return YES;
}


- (void)applicationWillResignActive:(UIApplication *)application {
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
}


- (void)applicationDidEnterBackground:(UIApplication *)application {
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}


- (void)applicationWillEnterForeground:(UIApplication *)application {
    // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
}


- (void)applicationDidBecomeActive:(UIApplication *)application {
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}


- (void)applicationWillTerminate:(UIApplication *)application {
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}


@end
