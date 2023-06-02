import React from 'react';
import { Dimensions, StyleSheet, Text, View, Image } from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';

export default function OpinionsView() {
  return (
    <View style={styles.mainDiv}>
        <Text>"sterdytfghijomkjilhugkyfjtdhrshtfgyhijlhugyjfthdrgsdfhghiluyktjfrhdegsdfhghukyjtfrhdegsdfghuiyktjrhedgszdfghuyjtrhegzsedthfygukytjrhegszdthfygj,uktjyfrhdegszdhfgjtyrhdegsd "</Text>
        <View style={styles.profileDiv}>
            <Image source={require('../../../assets/profile_photo_test.jpg')} style={styles.imageProfile}/>
            <View style={styles.detailProfileDiv}>
                <Text>Emily</Text>
                <Text>Il y a 4 mois</Text>
            </View>
        </View>
    </View>
  );
}

const styles = StyleSheet.create({
    mainDiv: {
        borderWidth:1,
        borderColor: "#000000",
        borderRadius: 20,
        padding:15,
        maxWidth:'25%',
        height:'100%',
        marginHorizontal:15,
    },
    profileDiv: {
        flexDirection: 'row',
        flexGrow:0,
        margin:10
    },
    imageProfile: {
        flex:1,
        height: '100%',
        maxWidth:'25%',
        margin: 5,
        borderWidth: 1,
        borderColor:'transparent',
        borderRadius: 90,
      },
    detailProfileDiv:{
        flex:2,
        marginHorizontal:10
      }
     
})
