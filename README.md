# social-platform-service

--------------------------------------------------------

It supports Following API's for social platform.

1. LeaderBoard API ("/leaderboard?email=") : This list down the user rank and user profile data like heart_rate, calories burnt.

2. Get Friend API("/friends?email=") : This list down all user friend on this social platform.

3. Get Favourite Videos("/videos/favourites?email="): This list down users all favourite video data.

4. Get Popular Videos("/videos/popular"): This list down all popular/trending video data based on videos priority.

Note: Need to pass Authorization in request Headers for ALL APIs to work. I have added Authorization value in Constant File in code.

-------------------------------------------------------------------------


Setup Commands:

1. Make sure you have java, jdk and maven installed on your system.
2. We are using postgres database in this application. So you have to download postgres also.
3. Create database incasa on you postgres db.
4. Run command mvn clean install. This will run all test cases. If it passed then your program is ready to run. You can use command mvn spring-boot::run


---------------------------------------------------------------

For better understanding comments have been added in the code in respective API flow.

Best of Luck!










