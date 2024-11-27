insert into employee values
            ('A101','Rajni','Kant','superstar@iiitb.ac.in','Superstar123','Director','Admin'),
            ('E101','Mahesh','Babu','universalstar@iiitb.ac.in','Universalstar123','Professor','ECE'),
            ('C101','vijay','thalapathy','master@iiitb.ac.in','Thalapathy123','Professor','CSE'),
            ('A102','Allu','Arjun','stylish@iiitb.ac.in','stylishstar123','Registar','Accounts');

insert into courses values
                ('CSE01','TOC','Theory Of Computation','Involves study of Finite Automata,PDA,Turing Machine,LBA','2000','Spring','Rajni Kant','150','150'),
                ('CSE02','DBMS','Database Management Systems','Covers relational databases, SQL, indexing, and transactions','2024','Fall','Pooja Mishra','4','120'),
                ('CSE03','OS','Operating Systems','Explores process management, memory management, and file systems','2024','Spring','Amit Shah','4','100'),
                ('CSE04','CN','Computer Networks','Focus on TCP/IP stack, routing protocols, and network security','2024','Winter','Suresh Kumar','4','140'),
                ('CSE05','AI','Artificial Intelligence','Introduction to AI, machine learning, and intelligent agents','2024','Fall','Geeta Roy','4','130'),

                ('ECE01','DSP','Digital Signal Processing','Focus on signal analysis, Fourier transforms, and filtering techniques','2024','Fall','Karan Bedi','4','110'),
                ('ECE02','VLSI','Very Large Scale Integration','Design and analysis of integrated circuits and microelectronics','2024','Spring','Sunita Mehta','4','90'),
                ('ECE03','EMFT','Electromagnetic Field Theory','Explores Maxwell’s equations and wave propagation','2024','Winter','Ajay Varma','4','120'),
                ('ECE04','Control','Control Systems','Covers system modeling, stability analysis, and control design','2024','Fall','Ravi Patel','4','100'),
                ('ECE05','MIC','Microwave Engineering','Study of microwave devices, antennas, and propagation','2024','Spring','Vijay Khanna','4','80'),

                ('DSAI01','ML','Machine Learning','Core concepts of supervised, unsupervised, and reinforcement learning','2024','Fall','Sneha Kapoor','4','140'),
                ('DSAI02','DS','Data Science','Focus on data preprocessing, visualization, and statistical methods','2024','Spring','Ankit Jain','4','130'),
                ('DSAI03','NLP','Natural Language Processing','Introduction to text processing, sentiment analysis, and language models','2024','Winter','Priya Sharma','4','120'),
                ('DSAI04','CV','Computer Vision','Study of image processing, feature extraction, and object detection','2024','Fall','Ramesh Iyer','4','110'),
                ('DSAI05','BigData','Big Data Analytics','Handling large datasets with Hadoop and Spark','2024','Spring','Arun Joshi','4','150');

insert into specialization_course values
                                      ('1','S01','CSE01'),
                                      ('2','S01','CSE02'),
                                      ('3','S01','CSE03'),
                                      ('4','S01','CSE04'),
                                      ('5','S01','CSE05'),
                                      ('6','S02','ECE01'),
                                      ('7','S02','ECE02'),
                                      ('8','S02','ECE03'),
                                      ('9','S02','ECE04'),
                                      ('10','S02','ECE05'),
                                      ('11','S03','DSAI01'),
                                      ('12','S03','DSAI02'),
                                      ('13','S03','DSAI03'),
                                      ('14','S03','DSAI04'),
                                      ('15','S03','DSAI05');