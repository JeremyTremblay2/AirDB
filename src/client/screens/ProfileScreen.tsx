import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import CardViewProfile from '../components/profile_components/CardViewProfile';

export default function App() {
  return (
    <View style={styles.container}>
      <CardViewProfile/>
      <Text>Description</Text>
      <Text>kojilhukgyjfthdrgchvjklpùkhtyfrgdefsghjklmkyhtfgrdsghjklmjghftdrsefghjklmjhgfdsqfghjklmgyhtfgrdesqfghjlpùmoilukyjthrgedfsdqfghyijomilukyjthfrgdfsfvghjklmjhgfdvsghjklhgnfbdvsxfghjkljhgnfbdvghjkhgnfbdvxsfcvghjgnfbdvxsfvghjkhgnfdxghjkhgfbdvxghj;hgnfbdcxvfghkjgnfbdvxccghjkfbdcvxcbnghkjgfcdvxcfvghukyjtghfdgcfghuiyghfdxvcfghuythfdcxvcguygfvcbnghjg</Text>
      
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
