import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';

export default function CardViewProfile() {
  return (
    <View style={styles.container}>
      <View>
        <Image source={require('../../assets/adaptive-icon.png')} style={styles.imageProfile}/>
        <Text>Jérémmy</Text>
      </View>
      <View>
        <Text>2</Text>
        <Text>Reviews</Text>
        
      </View>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "row",
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  imageProfile: {
    width: 200,
    height: '20%',
  },
});
