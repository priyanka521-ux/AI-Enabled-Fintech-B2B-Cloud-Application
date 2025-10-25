import axios from "axios";
export  const getData=async()=>{
    let response = await axios.get("http://localhost:8083/WinterProject/DataLoading");
   return(response.data.winter);
  // let data=response.data.winter;
   // data.map((winter,index)=>({...winter,"id":index}));
    //return data;
}

