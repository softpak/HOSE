#HOSE
`A flexible tube conveying data.`

####Minecraft Server with Multi-core CPU.

*   It`s based on Spigot v1.11.2. See http://www.spigotmc.org/ for details.

####Software & Hardware Requirements

Software :
*   OS : Anything that can run JDK or other JVM.
*   JVM : Oricale & Open JDK 1.8.

Hardware :
*   CPU : Any muilti-core CPUs.

####Test Server
*     IP address : 220.132.245.136:25585 (static)
*     Version : 1.11.2
*     Rule : `DO NOT interfere other players. Otherwise, you can find a wild open space to do things you like to test this server except red stone clock devices. Most of players are Taiwanese. If you are getting lag. You can try /gc command to check the ticks. Maybe your FPS is too low . You are welcome to leave any messages.`

####How to build this patch
*     Linux
  1. Build Spigot using BuildTools.jar.
  2. Import the project in Netbeans or Eclipse.
  3. Patch src.patch with "patch -p1 < ../src.patch" command in src folder.
  4. Then build the project in your IDE tools.
  5. The jar file can be found in target folder like "spigot-1.X.X-R0.1-SNAPSHOT.jar".
  6. Enjoy the new server with multi-core CPU.

####Issues
*     No issues for now.

####Settings
1. entity-piece(default:2): Splitting entity-list into pieces. In default, it`s 2 pieces. It can reduce the time looping the list.
2. entity-min-pertick(default:2000): If you split your entity-list in many pieces, this number will check the min number of entities every tick. To ensure your service goes well.

#[贊助(NTD)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=UMV8PH8TDHSCY)
#[Donate(USD)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=FYUVSZYQBPXF2)












