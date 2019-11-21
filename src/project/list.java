/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peopleark
 */

// This file contains all funtinaltiy of double linked list i.e
// in this file we wll use the nodes class to add,delete,find and display our data 

 public  class  list {
     
        private nodes node; // The node that points the head of the Doubly Linked List
        private nodes tail;// The node that points the tail of the Doubly Linked List
        int size = 0;   // Used to check the the number of elements in list
        int seed = 0;// Used to to set the Ids of each Data



        void addInFirst(People data) { // This function will be used to add the people with HIGH priority in the List
            
            if (node == null) { // if there is no Data in List
                node = new nodes(data);// add Data
                tail = node;// Point tail to it

            } else {// Else find the node where you can add the data
                nodes i = node;
                while(i.refrence != null && i.refrence.data.getLevel() <= data.getLevel()){// move to next until the next is last
                    // Or the if the next node's priority is less than HIGH
                    i = i.refrence;
                }
                if(i.data.getLevel() > data.getLevel()){ // If the current node's priority is less than data (to be inserted)
                    // Case: List has data  1,2 and we have to insert 0(high)

                    // Add to first node
                    
                    node.back = new nodes(data);// set Back to data (to be inserted) i.e 0<-1<=>2

                    node.back.refrence =  node; // Now set the Back's refrence to node  i.e 0<=>1<=>2
                    node = node.back;// Now set the head to the Higher priority data
                    
                    
                }else if(i.refrence != null){// if the list contains both high and less than that data (data =0)
                    // Case: list has 0<=>1<=>2
                    // using the above loop we are at ( i = )   \/
                    //                                           0<=>1<=>2
                    nodes temp = new nodes(data);
                    i.refrence.back = temp; // 0 data<-1<=>2

                    temp.refrence = i.refrence; // 0 data<=>1<=>2

                    temp.back = i;//      0<-data<-1<=>2
                    i.refrence = temp;// 0<=>data<-1<=>2
                }
                else{// The list contains data with high priority only (data = 0)
                    // Case: list has data 0<=>0
                    
                    i.refrence = new nodes(data);// 0<=>0->data
                    i.refrence.back = i; // 0<=>0->data
                    tail = i.refrence;// setting tail to point at data as it's the last one in list
                    tail.refrence = null;
                    tail.back = i;// point it previous to maintain the treversing refrences
                }
                
                
                
            }
            size++;
        }


        void addInLast(People data) { // This function is used add with low priority (data =2)

            if (tail == null) {// If there is no data in list
                tail = new nodes(data);// create and add it to tail
                node = tail;// refrence it to head
                size++;
            } else {// it has some data so update the tail refrences
//                0<=> 1<=> 2
                nodes temp = new nodes(data); // data node created
                temp.back = tail;//  0<=> 1<=> 2 <-data
                tail.refrence  = temp;//  0<=> 1<=> 2 <=>data
                tail = temp;// Update the tail refrenc to last 
                
                size++;
            }
        }



        void insertAtIndex(int index, People data) throws Exception {
            if (index < 1 || index > size ) {
                throw new Exception("Invalid Index");
            } else if (index == 1) {
                addInFirst(data);
            } else {
                int i = 1;
                nodes temp = node;
                nodes temp1 = new nodes(data);
                while (i != index - 1) {
                    temp = temp.refrence;
                    i++;
                }

                if (temp.refrence == null) {
                    temp1.refrence = temp;
                    temp1.back = temp.back;
                    temp.back.refrence = temp1;
                    temp.back = temp1;

                } else {
                    temp1.refrence = temp.refrence;
                    temp.refrence.back = temp1;
                    temp.refrence = temp1;
                    temp1.back = temp;
                }
                size++;

            }
        }

        public void display(JTable jTable1)  {// This function is used to get data from the list and disply to JTabele
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();// get refrencce
            model.setRowCount(0);// clear data
            nodes temp = node;
            while (temp != null) {// Move to next until you reach last data

                // Creat data to insert into table
                 Object[] row = { temp.data.getId(), temp.data.getFirstName(), temp.data.getLastName(), 
                 temp.data.getDateArival(),temp.data.getPassNumber(),temp.data.getLevel()};

//                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                model.addRow(row); // add data to row
                temp = temp.refrence;// move to next

            }

        }

      
        
      
        
        public int insertData(People data){// This function wil be called by main to be used to add data
            // it will decied what method to be used to add data
            int level = data.getLevel();
            data.setId(seed);// set Id of data
            if(level == 0){// priority is high
                addInFirst(data);
            }else if( level == 1){// priority medium
                insertMedium(data);
            }else if(level == 2){// priority is low
                addInLast(data);
            }
            return seed++;
        }
        public void insertData(People data ,int id ){// This function wil be called by main to be used to add data
            // it will decied what method to be used to add data
            int level = data.getLevel();
            data.setId(id);// set Id of data
            if(level == 0){// priority is high
                addInFirst(data);
            }else if( level == 1){// priority medium
                insertMedium(data);
            }else if(level == 2){// priority is low
                addInLast(data);
            }

        }
        void insertMedium( People data)  {// Insert Data whose priority is medium (data =2)
            if(size == 0){// if there is no data in list
                node = new nodes (data);
                tail = node;
            }else{// this code is same as in function addInFirst
                nodes i = node;
                while(i.refrence != null && i.refrence.data.getLevel() <= data.getLevel()){
                    i = i.refrence;
                }
                if(i.data.getLevel() > data.getLevel()){
                    nodes temp = new nodes(data);
                    temp.refrence = i;

                    node =  temp;
                    node.refrence.back = node;
                    
                }else if(i.refrence != null){
                    nodes temp = new nodes(data);
                    i.refrence.back = temp;

                    temp.refrence = i.refrence;

                    temp.back = i;
                    i.refrence = temp;
                }else{
                    i.refrence = new nodes(data);
                    i.refrence.back = i; 
                    tail = i.refrence;
                    tail.refrence = null;
                    tail.back = i;
                }
            }
            size++;
        }
        
        public void deleteId(int id, JTable jTable1){// delete data by ID
            
            if(size != 0){// if there is some data 
                
                nodes i = node;
                if(i.data.getId() == id){ // if 1st node has data to be deleted
                    nodes temp = node.refrence;
                    if(temp != null){
                        temp.back = null;
                        
                    }
                    node = temp;
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    size--;
                }
                else{
                    while( i.refrence != null ){ // while you do not reach last data move to next
                        if(i.refrence.data.getId() == id){ // if id is matched



                            if (i.refrence.refrence == null) { // if it is last node
                                tail = tail.back; // update tail
                                tail.refrence = null;// remove its refrence from tail 

                            }
                            else {  // else
                                i.refrence = i.refrence.refrence;// set the curent node's next to node + 2
                                i.refrence.back = i; // set the next node's back to node
                            }
                            // Update info to table
                            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            model.setRowCount(0);
                            size--;
                            break;// end loop

                        }
                        i = i.refrence ; // move to next 
                    }
                }

            }
        }
        
        public void findById(int id , JTable jTable1){
            
            if(size != 0){
                
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();//clear table in UI
                model.setRowCount(0);
                nodes i = node;
                if(i.data.getId() == id){// if firsy element has the id
                    Object[] row = { i.data.getId(), i.data.getFirstName(), i.data.getLastName(), 
                     i.data.getDateArival(),i.data.getPassNumber(),i.data.getLevel()};//add it's data to table

                    model.addRow(row);

                }
                else{
                    while( i.refrence != null ){// find the that node
                        if(i.refrence.data.getId() == id){//if next node has id 
                            i = i.refrence ;// move to it
                            Object[] row = { i.data.getId(), i.data.getFirstName(), i.data.getLastName(), //update table
                            i.data.getDateArival(),i.data.getPassNumber(),i.data.getLevel()};


                            model.addRow(row);
                            break;

                        }
                        i = i.refrence ;//move next
                    }
                }

            }
            
        }
        
        public  ArrayList<Integer> deleteN(int n, JTable jTable1){
            ArrayList<Integer> list = new ArrayList();// array to store id to be used by SQL
            if(size != 0){
                int i = 0;
                while(i < n && i < size ){//start from last  use tail to remove refrence of nodes until N nodes are removed or list is empty
                    list.add(tail.data.getId());
                    tail = tail.back;
                    if(tail != null){
                        tail.refrence = null;
                        
                    }else{// this is is last node is to removed i.e atfer this size =0
                        node = tail;
                    }
                    
                    i++;

                }
                if(n>size){ size = 0;}
                else{size-=n;}//update size
            }
            return list;
        }

        
        public void setSeed(int seed) {//set initila seed for ids
            this.seed = seed;
        }

    public int getSeed() {
        return seed;
    }
        

    public void updateById(int id, String firstName, String lastName, String passNumber, String dateArival , JTable jTable1) {
        if(size != 0){
                
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                nodes i = node;
                if(i.data.getId() == id){// if firts node has desired id
                    i.data.setFirstName(firstName);
                    i.data.setDateArival(dateArival);
                    i.data.setLastName(lastName);
                    i.data.setPassNumber(passNumber);
                    Object[] row = { i.data.getId(), i.data.getFirstName(), i.data.getLastName(), 
                     i.data.getDateArival(),i.data.getPassNumber(),i.data.getLevel()};
                    
                    model.addRow(row);

                }
                else{
                    while( i.refrence != null ){// move next till you find id
                        if(i.refrence.data.getId() == id){ // if id found
                            // update data in node
                            i.refrence.data.setFirstName(firstName);
                            i.refrence.data.setDateArival(dateArival);
                            i.refrence.data.setLastName(lastName);
                            i.refrence.data.setPassNumber(passNumber);
                            //update table
                            Object[] row = { i.refrence.data.getId(), i.refrence.data.getFirstName(), i.refrence.data.getLastName(), 
                            i.refrence.data.getDateArival(),i.refrence.data.getPassNumber(),i.refrence.data.getLevel()};


                            model.addRow(row);
                            break;

                        }
                        i = i.refrence ;
                    }
                }

            }
    }
        
    }