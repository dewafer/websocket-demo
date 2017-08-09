# WEBSOCKET-DEMO

This is a prototype project demonstrated how to build a web socket project using Spring Boot and Vue.

In this project, there is a ticker service emitting message to the Vue client every one second.
And in the Vue UI client, there is an input and button to send message back to the server and 
the server will log that message to the console.

## How to build and run

Build with gradle:

```bash
> ./gradlew clean build
```

You can also run using spring-boot plugin:

```bash
> ./gradlew bootRun
```

This probject will build into a war file, you can deploy that war file into your app server,
or you can also just run that war file using `java -jar build/libs/websocket-demo-0.0.1-SNAPSHOT.war`.

To build the Vue UI, make sure `npm` is installed on your system and

```bash
> cd src/main/frontend
> npm install && npm run build
```

Please refer to the UI's [README file](./src/main/frontend/README.md).

Then UI will be built into `src/main/resources/static`. The server will host the ui static files.

Note that you don't have to build the UI, it's pre-built and included in the source.

After all builds are successful, open [http://localhost:8080](http://localhost:8080) in your web browser.

## How to debug Vue

If you want to debug the UI, you can cd into the frontend folder and just run the dev build like this:

```bash
> cd src/main/frontend
> npm run dev
```

Remember to run `npm install` beforehand.

## What's to learn?

### For Spring's WebSocket's support:

* First, to enable websocket in Spring Boot, you should include `spring-boot-starter-websocket` in your dependency.
* Second, config a message borker like this one [WebSocketConfig.java](./src/main/java/com/dewafer/demo/websocketdemo/config/WebSocketConfig.java).
* The `@EnableWebSocketMessageBroker` is required, Spring's auto config won't auto-config that for you.
* To receive message from client, use `@MessageMapping` annotation on controllers, like `@RequestMapping` does.
* To send message to client, use `@SendTo` annotation on controllers, like `@ResponseBody` does.
* Note that if you are sending message on threads other than controllers, `@SendTo` won't work 
  (Not 100% sure, I'm sure it doesn't work on `@Scheduled` methods).
* To send message from things other than controllers, `SimpMessagingTemplate` is required. 
  Refer to [TickService.java](./src/main/java/com/dewafer/demo/websocketdemo/service/TickService.java) for more details.
* Spring Websocket support is based on SockJS and Stomp.
* Please refer to [26. WebSocket Support](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#websocket) 
official document for more details. (It's a very long doc, please be patient.)
* And there's a quick guide in Spring guides called [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/) to let you get started very fast.

### For Vue's:

* I couldn't find a good SockJS and Stomp plugin for Vue, if you know one please let me know thanks.
* So to communicate with Spring's websocket, `sockjs-client` and `webstomp-client` are used.
* WebSocket is connected when the `Home` component is mounted, 
  please refer to [Home.vue](./src/main/frontend/src/components/Home.vue) for more details.
* The code about SockJS and Stomp was refered from [Create a browser client](https://spring.io/guides/gs/messaging-stomp-websocket/#_create_a_browser_client) 
 section from Spring's guide, but the origin one is using JQuery.

## TODOs

* Change WebSocket messages into json instead of string.
* Refactor WebSocket in `Home.vue` into a service utilizing `Promise` or a Vue plugin (Don't know how to write Vue plugin).
* Refactor into meanful demo like a web chat app or message notification app.
* Integrate npm build process into gradle build.
* Separate frontend and backend into 2 isolated projects???