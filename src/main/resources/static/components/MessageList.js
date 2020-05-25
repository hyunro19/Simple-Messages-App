import MessageListItem from './MessageListItem.js';
import lifecycleLogger from '../mixins/lifecycle-logger.mixin.js';

export default {
  name: 'MessageList',
  mixins: [lifecycleLogger],
  template: `<ul><message-list-item v-for="item in items"
  v-bind:item="item" v-bind:key="item.id" v-on:delete="deleteMessage(item)">
  </message-list-item></ul>`,
  props: {
    items: {
      type: Array,
      required: true
    }
  },
  methods: {
    deleteMessage (message) {
      this.$emit('delete', message)
    }
  },
  components: {
    MessageListItem:MessageListItem
  },
}