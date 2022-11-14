import {Button, Text, View} from 'react-native';
import React, {useEffect} from 'react';
import {NativeModules, NativeEventEmitter} from 'react-native';
const {CalendarModule} = NativeModules;
const eventEmitter = new NativeEventEmitter(CalendarModule);
//console.log(CalendarModule);
//CalendarModule.createCalendarEvent(res => console.log(res));
const App = () => {
  // useEffect(() => {
  //   eventEmitter.addListener('EventCount', eventCount => {
  //     console.log(eventCount);
  //   });
  //   return () => {
  //     eventEmitter.removeAllListeners();
  //   };
  // }, []);

  const onSubmit = async () => {
    try {
      const eventId = await CalendarModule.createCalendarEvent();
      console.log(`Created a new event with id ${eventId}`);
    } catch (e) {
      console.error(e);
    }
  };
  return (
    <View>
      <Text>App</Text>
      <Button title="Call" onPress={onSubmit} />
    </View>
  );
};

export default App;
