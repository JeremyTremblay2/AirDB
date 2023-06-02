import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { FlatList, ScrollView, StyleSheet, Text, View } from 'react-native';
import CardViewProfile from '../components/profile_components/CardViewProfile';
import OpinionsView from '../components/profile_components/opinions_components/OpinionsView';

export default function App() {
  return (
    <ScrollView>
        <View style={styles.container}>
        <View style={styles.divCardViewProfile}>
          <CardViewProfile/>
        </View>
        
        <Text style={[styles.margin, styles.subTitle]}>Description</Text>
        <Text style={styles.margin}>kojilhukgyjfthdrgchvjklpùkhtyfrgdefsghjklmkyhtfgrdsghjklmjghftdrsefghjklmjhgfdsqfghjklmgyhtfgrdesqfghjlpùmoilukyjthrgedfsdqfghyijomilukyjthfrgdfsfvghjklmjhgfdvsghjklhgnfbdvsxfghjkljhgnfbdvghjkhgnfbdvxsfcvghjgnfbdvxsfvghjkhgnfdxghjkhgfbdvxghj;hgnfbdcxvfghkjgnfbdvxccghjkfbdcvxcbnghkjgfcdvxcfvghukyjtghfdgcfghuiyghfdxvcfghuythfdcxvcguygfvcbnghjg</Text>
        <OpinionsView name='Jérémy'/>
      </View>
    </ScrollView>
    
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'center',
  },
  margin:{
    marginHorizontal:20,
    marginVertical:5
  },
  divCardViewProfile: {
   alignItems:'center' 
  },
  subTitle: {
    fontSize:20,
  }
  
});
