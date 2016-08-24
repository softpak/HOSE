#HOSE
`A flexible tube conveying data.`

####Minecraft Server with Multi-core CPU.
ForkJoin maybe the way to solve ticking issues.

<<<<<<< HEAD
*   It`s based on Spigot v1.10.2. See http://www.spigotmc.org/ for details.
=======
*   It`s based on Paper v1.10.2. See https://paper.emc.gs/ for details.
>>>>>>> f86f1899c8b007429e41b90e0b96be504ec68407

####Software & Hardware Requirements

Software :
*   OS : Anything that can run JDK or other JVM.
*   JVM : Oricale & Open JDK 1.8.

Hardware :
*   CPU : Any muilti-core CPUs.

####Test Server
*     IP address : 220.132.245.136:25585 (static)
*     Version : 1.10.2
*     Rule : `DO NOT interfere other players. Otherwise, you can find a wild open space to do things you like to test this server except red stone clock devices. Most of players are Taiwanese. If you are getting lag. You can try /gc command to check the ticks. Maybe your FPS is too low . You are welcome to leave any messages.`

####How to build this patch
*     Linux
  1. Build Spigot using BuildTools.jar.
  2. Import the project in Netbeans or Eclipse.
  3. Patch src.patch with "patch -p1 < ../src.patch" command in src folder.
  4. Then build the project in your IDE tools.
  5. The jar file can be found in target folder like "spigot-1.X.X-R0.1-SNAPSHOT.jar".
  6. Enjoy the new server with multi-core CPU.

####Settings
*     wetp-core-multiple:1(default) #Using threads that are multiple by the numbers of your cpu cores. If your cpu has 2 cores. It will use 2 threads to calculate EntityTicks. Set it to 10 will use 20 threads.

####Issues
*     No issues for now.

#[贊助(NTD)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=UMV8PH8TDHSCY)
#[Donate(USD)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=FYUVSZYQBPXF2)












