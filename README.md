[![codebeat badge](https://codebeat.co/badges/eb4e6ae6-f70b-4da4-a757-8b6c2c62e5ba)](https://codebeat.co/projects/github-com-adrielcafe-readnbuy)
[![platform](https://img.shields.io/badge/platform-Android-brightgreen.svg)](https://android.com)
[![license](https://img.shields.io/badge/license-MIT-yellow.svg)](https://github.com/adrielcafe/ReadnBuy#license)

![logo](https://raw.githubusercontent.com/adrielcafe/ReadnBuy/master/app/src/main/res/mipmap-xxhdpi/ic_launcher.png)


# Read n' Buy
> **Read n' Buy** is an open source Android app developed at the Vanhackathon for Shopify's challenge.


## Demo Video
[![Read n' Buy Demo Video](http://img.youtube.com/vi/74yI7o13a50/0.jpg)](https://www.youtube.com/watch?v=74yI7o13a50 "Read n' Buy Demo Video")


## Project
Read n' Buy is a **news app**. But instead of showing the traditional advertising banners he is integrated with Shopify and allows the users **buy without leave the app**.

*What's the problem with ads?* First of all, they are ugly. Second thing, they are annoying. When you click on an ad banner this is what happens:
- You leave the app and go to the browser
- Add the product to the cart
- Login (if needed)
- And then you do checkout
- You still have to back to the app

**This ruins the user experience and drastically decreases the conversion rate.**

On my project I've tried to fix this. There are two objectives: 1) **increase the conversion rate** and 2) **simplify the buy flux**. 

To do it, first we need to **bring the shop to the app**. With the Shopify SDK I'm able to:
- Allow users do login/logout with their shop credentials (so I can get their email, shipping address and so on)
- Get the product descriptions
- Buy products (add them to the cart and do checkout without leave the app)

I'm using the [Native Checkout](https://help.shopify.com/api/sdks/mobile-buy-sdk/android/integration-guide/checkout#using-native-checkout), this grants a seamless buy flux. 

On my tests I took 1~2 minutes to buy a product when I clicked on an ad banner. With my approach I took less than 30 seconds!


## Why?

> **The growth of mobile will force brands to optimize mobile checkout:** With mobile commerce expected to grow at a rate 300% faster than traditional e-Commerce, according to discount and deals site Coupofy, more brands are likely to focus on implementing a seamless checkout experience in the coming year.

![MoovWeb Chart](http://moovweb.com/cnt/uploads/2015/12/Holiday-report-14-1-1024x577.png)

Source: [Retail TouchPoints](http://www.retailtouchpoints.com/topics/mobile/7-mobile-commerce-trends-to-watch-in-2016#docs-internal-guid-136d31b9-32a6-60dd-ff89-0e4e90a567e0) and [MoovWeb](http://www.moovweb.com/blog/mobile-commerce-trends-2016/)

---

> **New mobile marketing channels:** Today, Facebook has a ‘Shop Now’ call-to-action, Instagram also has a ‘Shop Now’ button under posts, and Pinterest has “Buyable Pins”, improving the buying journey immensely on mobile devices.

![Pixelter Image](https://blog.pixelter.com/wp-content/uploads/2016/02/image08-1.png)

Source: [Pixelter](https://blog.pixelter.com/mobile-commerce-trends-2016/) 

---

> **Mobile Ad Spend still lags behind Mobile Media Consumption:** Despite the growth in media time above, some advertisers are missing out since the right-most bar shows that there is a huge missing opportunity on mobile advertising.

![Smart Insights Chart](https://s3.amazonaws.com/upload.screenshot.co/3229bc9580)

Source: [Smart Insights](http://www.smartinsights.com/mobile-marketing/mobile-marketing-analytics/mobile-marketing-statistics/)


## Final Thoughts
I believe that the future of commerce will be a seamless and convenient mobile experience, when costumers will be invited to buy products in a non-intrusive way.

Some other features that will impact more and more the M-Commerce and E-Commerce are:
* Privacy control
* Gamefication
* Loyalty programs
* Instant gratification


## Coded With
* [Kotlin](https://kotlinlang.org/)
* [RxJava](https://github.com/ReactiveX/RxJava) and [RxBus](https://github.com/Dimezis/RxBus)
* [Shopify SDK](https://github.com/Shopify/mobile-buy-sdk-android)
* [MVP Pattern](http://antonioleiva.com/mvp-android/)


## License
> The MIT License (MIT)
> 
> Copyright (c) 2016 Adriel Café
> 
> Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
> 
> The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
> 
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
