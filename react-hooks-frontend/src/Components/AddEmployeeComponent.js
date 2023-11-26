import React, { useEffect, useState } from 'react'
import EmployeeService from '../services/EmployeeService'
import { useNavigate ,useParams} from 'react-router-dom'
import { Link } from 'react-router-dom'

export const AddEmployeeComponent = () => {

   const [firstName, setFirstName] = useState('')
   const [lastName, setLastName] = useState('')
   const [emailId, setEmailId] = useState('')
   const navigate= useNavigate()
   const {id}=useParams();

   const saveOrUpdateEmployee=(e)=>{
    e.preventDefault();
    const employee={ firstName,lastName,emailId}

    if(id){
        EmployeeService.updatEmployee(id,employee).then((response)=>{
            navigate('/employees');
        }).catch(error=>{
            console.log(error)
           })


    }else{
        EmployeeService.createEmployee(employee).then((response) =>{
            console.log(response.data)
            navigate('/employees');
    
           }).catch(error=>{
            console.log(error)
           })
        

     }

     }

   useEffect( ()=>{
    EmployeeService.getEmployeeById(id).then((response)=>{
        setFirstName(response.data.firstName)
        setLastName(response.data.lastName)
        setEmailId(response.data.emailId)

    }).catch(error=>{
        console.log(error)
    })

   },[])

  const title=()=>{
       if(id){
             return<h2 className='text-center'>Update Employee</h2>
       }else{
        
           return<h2 className='text-center'>Add Employee</h2>
      }
   }
  return (
    <div>
        <br/> <br/>

        <div className='container'>

            <div className='row'>
                <div className='card col-md-6 offset-md-3'>
                 
                    {
                        title()
                    }
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                  <label className='form-label' > First Name:</label>
                                 <input  type='text'
                                 placeholder='enter first name'
                                 name='firstName'  
                                 className='form-control'
                                 value={firstName}
                                 onChange={ (e)=> setFirstName(e.target.value)}>
                                 </input>

                            </div>
                            <div className='form-group mb-2'>
                                  <label className='form-label' > Last Name:</label>
                                 <input  type='text'
                                 placeholder='enter last name'
                                 name='lastName'  
                                 className='form-control'
                                 value={lastName}
                                 onChange={ (e)=> setLastName(e.target.value)}>
                                 </input>


                            </div>
                            <div className='form-group mb-2'>
                                  <label className='form-label' > Email Id:</label>
                                 <input  type='text'
                                 placeholder='enter your EmailID'
                                 name='emailId'  
                                 className='form-control'
                                 value={emailId}
                                 onChange={ (e)=> setEmailId(e.target.value)}>
                                 </input>

                            </div>
                            <button className='btn btn-success' onClick={ (e)=> saveOrUpdateEmployee(e)}>Submit</button>
                              <Link to='/employees' className='btn  btn-danger'>Cancel</Link> 
                        </form>


                    </div>
                </div>

            </div>
        </div>
      
    </div>
  )
}
