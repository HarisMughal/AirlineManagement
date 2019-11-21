/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Mark
 */
// This class defines the structure of a node in doubly linked list

class nodes {

        public People data; // Data in Node
        nodes refrence; // Refrence to next node
        nodes back; // Refrence to previous node
        //Setter
        void setData(People data) {
            this.data = data;
        }
        
        //Constructor
        public nodes(People data) {
            this.data = data;
        }
}
