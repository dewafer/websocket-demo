<template>
  <div>
    <h1>Home</h1>
    <h2>Send Message</h2>
    <div>
      <input v-model="send_message" placeholder="Send Message">
      <button @click="send">Send</button>
    </div>
    <h2>Message Received</h2>
    <p>{{ received_messages }}</p>
  </div>
</template>

<script>
 export default {
   name: 'home',
   data () {
     return {
       received_messages: [],
       send_message: null
     }
   },
   methods: {
     send () {
       console.log('Send message:' + this.send_message)
     }
   }
 }
</script>
