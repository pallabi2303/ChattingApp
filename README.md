Problem Statement 
 
The objective of this project is to implement a simple chat application using a 
client-server model with TCP/IP communication. chat application project 
involves designing and implementing a client-server architecture for real-time 
communication between users. The key elements and their functionalities are 
outlined below: 
1. Server Component (ChatServer): 
Responsibility: Listens for incoming connections and handles communication 
with connected clients. 
User Interaction: The server does not directly interact with the user through the 
console. It runs in the background, waiting for client connections. 
Constraints: The server's main constraint is its passive role; it does not actively 
send messages unless a client initiates communication. 
2. Client Component (ChatClient): 
Responsibility: Establishes a connection to the server, sends user input to the 
server, and receives and displays responses. 
User Interaction: The client actively interacts with the user through the console, 
prompting for input and displaying messages. 
Constraints: The client's primary constraint is its reliance on user input for 
message content. It continuously waits for user input and may face limitations if 
the user does not provide messages. 
3. Communication Protocol (TCP/IP): 
Methodology: Utilizes the TCP/IP protocol for reliable, ordered communication 
between the server and client. This ensures the seamless exchange of messages. 
Constraints: The constraint lies in the synchronous nature of TCP/IP 
communication, meaning that one party sends, and the other receives, creating 
a sequential exchange. 
4. Constraints and Considerations: 
Error Handling: Both server and client components include exception handling 
to address potential errors, ensuring robustness. 
Continuous Execution: Both components run in infinite loops, allowing 
continuous communication.  
 
3.Methodology 
 
Server side : 
1. Start the server. 
2. Create a ServerSocket on a specific port (e.g., 5000). 
3. Print a message indicating that the server has started and is waiting for 
clients. 
4. Wait for a client to connect using serverSocket.accept(). 
5. Upon a client connection, print a message indicating the client's connection. 
6. Create input and output streams (DataInputStream and DataOutputStream) 
for communication with the client. 
7. Create a separate thread for the server to send messages to the client. 
   a. Inside the thread, use a loop to continuously read messages from the 
server's console. 
   b. Send each message to the client using outputStream.writeUTF(message) 
and flush the stream. 
8. In the main thread, use a loop to continuously receive messages from the 
client. 
   a. Read each message from the client using inputStream.readUTF(). 
   b. Print the received message with an indication that it's from the client. 
9. Handle exceptions appropriately (e.g., IOException). 
 
Client side :  
1. Start the client. 
2. Create a Socket to connect to the server on a specific IP address and port 
(e.g., "localhost", 5000). 
3. Print a message indicating that the client is connected to the server. 
4. Create input and output streams (DataInputStream and DataOutputStream) 
for communication with the server. 
5. Create a separate thread for the client to receive messages from the server. 
   a. Inside the thread, use a loop to continuously read messages from the 
server. 
   b. Print each received message with an indication that it's from the server. 
6. In the main thread, use a loop to continuously read messages from the user. 
   a. Read each message entered by the user from the console. 
   b. Send the user's message to the server using 
outputStream.writeUTF(message) and flush the stream. 
7. Handle exceptions appropriately (e.g., IOException)
