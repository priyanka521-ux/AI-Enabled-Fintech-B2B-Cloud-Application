import './App.css';
import react from "react";
import MaterialTable from "material-table";
import tableIcons from "./MaterialTableIcons"; 
import  { getData } from './dataFetch';
import {useState,useEffect} from "react";
//import {makeStyles} from  "@material-ui/core/styles";
 



function App() {
  const [tableData, setTableData] = useState([]);
 

  const columns = [
    { title: "Sl no", field: "sl_no", editable: false },
    { title: "Bussiness Code", field: "business_code" },
    { title: "Customer Number", field: "cust_number" },
    { title: "Clear Date", field: "clear_date" },
    { title: "Bussiness Year", field: "buisness_year" },
    { title: "Document Id", field: "doc_id" },
    { title: "Posting Date", field: "posting_date" },
    { title: "Document Create Date", field: "document_create_date" },
    { title: "Due Date", field: "due_in_date" },
    { title: "Invoice Currency", field: "invoice_currency" },
    { title: "Document Type", field: "document_type" },
    { title: "Posting Id", field: "posting_id" },
    { title: "Total Open Amount", field: "total_open_amount" },
    { title: "Baseline Create Date", field: "baseline_create_date" },
    { title: "Customer Payment Terms", field: "cust_payment_terms" },
    { title: "Invoice Id", field: "invoice_id" },
  ];

useEffect(async () => {
    setTableData(await getData());
},[])
    return(
      <>
      <p style={{fontWeight:'bold'}}>ABC Products <span style={{textAlign:'center'}}> highradius</span></p>
  
    <MaterialTable style={{backgroundColor:'rgb(40,61,74)',color:'white'}} 
       icons={tableIcons}
       columns={columns}
       data={tableData}
       options={{selection:true,search:false,padding:"dense",showTitle:false,color:'white',
       headerStyle:{backgroundColor:'rgb(40,61,74)',color:'white'},}}
       >

    </MaterialTable>
    </>
    );
  
}

export default App; 

