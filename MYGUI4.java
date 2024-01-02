import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class MYGUI4 {

    // table1을 static으로 선언
        private static JTable table1;

    

    public static void main(String[] args) {

        MYGUI4 myGUI3 = new MYGUI4(); // 객체 생성

        

        JFrame myGUI4 = new JFrame();
        myGUI4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUI4.setLocationRelativeTo(null);
        // myGUI.setResizable(false);
        myGUI4.setSize(600, 500);
        myGUI4.setTitle("최동혁의 GUI");


        

        // step #1
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Top Field"));
        myGUI4.add(panel1, BorderLayout.NORTH);
        // #1-2
        panel1.add(new JLabel("학번:"));
        JTextField txtSID = new JTextField(6);
        txtSID.setFont(new Font("고딕", Font.BOLD, 15));
        panel1.add(txtSID);

        panel1.add(new JLabel("이름:"));
        JTextField txtNAME = new JTextField(5);
        txtNAME.setFont(new Font("고딕", Font.BOLD, 15));
        panel1.add(txtNAME);

        panel1.add(new JLabel("전공:"));
        JTextField txtSCORE1 = new JTextField(3);
        txtSCORE1.setFont(new Font("고딕", Font.BOLD, 15));
        panel1.add(txtSCORE1);

        panel1.add(new JLabel("교양:"));
        JTextField txtSCORE2 = new JTextField(3);
        txtSCORE2.setFont(new Font("고딕", Font.BOLD, 15));
        panel1.add(txtSCORE2);
        // #1-3
        JButton btnINSERT = new JButton("INSERT");
        btnINSERT.setFont(new Font("고딕", Font.BOLD, 13));
        btnINSERT.setBackground(Color.green);
        panel1.add(btnINSERT);

        JButton btnDELETE = new JButton("DELETE");
        btnDELETE.setFont(new Font("고딕", Font.BOLD, 13));
        btnDELETE.setBackground(Color.red);
        panel1.add(btnDELETE);

        panel1.add(new JLabel("| 학번 조회하기 |:"));
        JTextField txtSIDSEARCH = new JTextField(6);
        txtSIDSEARCH.setFont(new Font("고딕", Font.BOLD, 15));
        panel1.add(txtSIDSEARCH);

        JButton btnSIDSEARCH = new JButton("조회하기");
        btnSIDSEARCH.setFont(new Font("고딕", Font.BOLD, 13));
        btnSIDSEARCH.setBackground(Color.white);
        panel1.add(btnSIDSEARCH);

        panel1.add(new JLabel("| 이름 조회하기 |:"));
        JTextField txtSNAMESEARCH = new JTextField(6);
        txtSNAMESEARCH.setFont(new Font("고딕", Font.BOLD, 15));
        panel1.add(txtSNAMESEARCH);

        JButton btnSNAMESEARCH = new JButton("조회하기");
        btnSNAMESEARCH.setFont(new Font("고딕", Font.BOLD, 13));
        btnSNAMESEARCH.setBackground(Color.white);
        panel1.add(btnSNAMESEARCH);

        


        // step #2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(7, 1, 5, 5));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "기본작업"));

        JButton btn1 = new JButton("행 추가");
        btn1.setFont(new Font("고딕", Font.BOLD, 15));
        btn1.setBackground(Color.yellow);
        panel2.add(btn1);

        JButton btn2 = new JButton("행 삭제");
        btn2.setFont(new Font("고딕", Font.BOLD, 15));
        btn2.setBackground(Color.yellow);
        panel2.add(btn2);

        JButton btn3 = new JButton("값 설정");
        btn3.setFont(new Font("고딕", Font.BOLD, 15));
        btn3.setBackground(Color.yellow);
        panel2.add(btn3);

        JButton btn4 = new JButton("셀 정렬");
        btn4.setFont(new Font("고딕", Font.BOLD, 15));
        btn4.setBackground(Color.yellow);
        panel2.add(btn4);

        JButton btn5 = new JButton("셀 크기");
        btn5.setFont(new Font("고딕", Font.BOLD, 15));
        btn5.setBackground(Color.yellow);
        panel2.add(btn5);

        JButton btn6 = new JButton("열 이동");
        btn6.setFont(new Font("고딕", Font.BOLD, 15));
        btn6.setBackground(Color.yellow);
        panel2.add(btn6);

        myGUI4.add(panel2, BorderLayout.WEST);
        // step #3
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(7, 1, 5, 5));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "관리작업"));

        JButton btn31 = new JButton("JOB#31");
        btn31.setFont(new Font("고딕", Font.BOLD, 15));
        btn31.setBackground(Color.yellow);
        panel3.add(btn31);

        JButton btn32 = new JButton("파일저장");
        btn32.setFont(new Font("고딕", Font.BOLD, 15));
        btn32.setBackground(Color.yellow);
        panel3.add(btn32);

        JButton btn33 = new JButton("읽어오기");
        btn33.setFont(new Font("고딕", Font.BOLD, 15));
        btn33.setBackground(Color.yellow);
        panel3.add(btn33);

        JButton btn34 = new JButton("합계&등급");
        btn34.setFont(new Font("고딕", Font.BOLD, 15));
        btn34.setBackground(Color.yellow);
        panel3.add(btn34);

        JButton btn35 = new JButton("파일출력");
        btn35.setFont(new Font("고딕", Font.BOLD, 15));
        btn35.setBackground(Color.yellow);
        panel3.add(btn35);

        JButton btn36 = new JButton("이름정렬");
        btn36.setFont(new Font("고딕", Font.BOLD, 15));
        btn36.setBackground(Color.yellow);
        panel3.add(btn36);

        JButton btn37 = new JButton("HTML");
        btn37.setFont(new Font("고딕", Font.BOLD, 15));
        btn37.setBackground(Color.yellow);
        panel3.add(btn37);

        JButton btn38 = new JButton("CSV");
        btn38.setFont(new Font("고딕", Font.BOLD, 15));
        btn38.setBackground(Color.yellow);
        panel3.add(btn38);

        JButton btn39 = new JButton("그래프");
        btn39.setFont(new Font("고딕", Font.BOLD, 15));
        btn39.setBackground(Color.yellow);
        panel3.add(btn39);

        myGUI4.add(panel3, BorderLayout.EAST);
        // step #4
        JLabel lblSID = new JLabel("작성자 : 최동혁(2018E7196)");
        lblSID.setFont(new Font("고딕", Font.BOLD, 20));

        myGUI4.add(lblSID, BorderLayout.SOUTH);
        // step #5
        String header[] = { "학번", "이름", "전공", "교양", "합계", "평균", "등급", "석차", "과목별평균"};
        DefaultTableModel model = new DefaultTableModel();
        table1 = new JTable(model);
        for (int C = 0; C < header.length; C++) {
            model.addColumn(header[C]);
        }
        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setLocation(10, 50);
        scrollPane.setSize(300, 200);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Score Table"));

        myGUI4.add(scrollPane, BorderLayout.CENTER);


        




        // step #6
        btnINSERT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int R;
                model.addRow(new Object[] {});

                R = table1.getRowCount() - 1;
                table1.setValueAt(txtSID.getText(), R, 0);
                table1.setValueAt(txtNAME.getText(), R, 1);

                table1.setValueAt(txtSCORE1.getText(), R, 2);
                table1.setValueAt(txtSCORE2.getText(), R, 3);
                int totalScore = Integer.parseInt(txtSCORE1.getText()) + Integer.parseInt(txtSCORE2.getText());
                table1.setValueAt(totalScore, R, 4);

                double average = totalScore / 2.0;
                table1.setValueAt(average, R, 5);

                // 등급 계산
                String grade = calculateGrade(average);
                table1.setValueAt(grade, R, 6);

                // 석차 계산 및 표시
                calculateRank();
                table1.setValueAt(getRank(Integer.parseInt(txtSID.getText())), R, 7);

                table1.setValueAt(average, R, 8);
                
                
            }
        });
        btnDELETE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] rows = table1.getSelectedRows(); // 선택된 행만 지운다.
                for (int x = 0; x < rows.length; x++) {
                    model.removeRow(rows[x] - x);
                }
            }
        });
        // step #7
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[] {});
            }
        });
        // #7-2
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (table1.getRowCount() > 0) {
                    model.removeRow(0);
                }
            }
        });
        // #7-3
        btn3. addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int R = 0; R < table1.getRowCount(); R++) {
                    for (int C = 0; C < table1.getColumnCount(); C++) {
                         table1.setValueAt(123, R, C);
                    }
                 }
             }
        });
        // #7-4
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int C = 0; C < table1.getColumnCount(); C++) {
                     table1.getColumnModel().getColumn(C).setCellRenderer(rightRenderer);
                } 
             }
        });
        // #7-5
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table1.setRowHeight(25);  // 행 높이 설정
        
                table1.getColumnModel().getColumn(0).setPreferredWidth(60);  // 셀 너비 설정
                table1.getColumnModel().getColumn(1).setPreferredWidth(50);
                table1.getColumnModel().getColumn(2).setPreferredWidth(30);
                table1.getColumnModel().getColumn(3).setPreferredWidth(30);
                table1.getColumnModel().getColumn(4).setPreferredWidth(30);
                table1.getColumnModel().getColumn(5).setPreferredWidth(20);
            }
        });
        // #7-6
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               int[] rows = table1.getSelectedRows();
               int destination = rows[0] + (-1); // -1 이면 위로 1 이면 아래로
               int rowCount = model.getRowCount();
         
               if (destination < 0 || destination >= rowCount) { return; }
         
               model.moveRow(rows[0], rows[rows.length - 1], destination);
               table1.setRowSelectionInterval(rows[0] + (-1), rows[rows.length - 1] + (-1));
               // -1 이면 위로 1 이면 아래로
            }
         });
        // #7-7
        btn32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (FileWriter myWriter = new FileWriter("c:/temp/R00_2018E7196.txt")) {
                    for (int R = 0; R < table1.getRowCount(); R++) {
                        for (int C = 0; C < table1.getColumnCount(); C++) {
                              myWriter.write(table1.getValueAt(R, C) + " ");
                        }
                        myWriter.write("\n");
                     }
                     myWriter.close();
                 } catch (IOException e1) {
                    e1.printStackTrace();
                 }
             }
         });
        // #7-8
        btn33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File myObj = new File("c:/temp/R00_2018E7196.txt");
                String D[];
                int R= table1.getRowCount();
         
                try (Scanner myReader = new Scanner(myObj)) {
                     while (myReader.hasNextLine()) {
                        model.addRow(new Object[] {});
                        String data = myReader.nextLine();
                        D = data.split(" ");
                        table1.setValueAt(D[0], R, 0);
                        table1.setValueAt(D[1], R, 1);
                        table1.setValueAt(D[2], R, 2);
                        table1.setValueAt(D[3], R, 3);
                        table1.setValueAt(D[4], R, 4);
                        table1.setValueAt(D[5], R, 5);
                        table1.setValueAt(D[6], R, 6);
                        table1.setValueAt(D[7], R, 7);
                        table1.setValueAt(D[8], R, 8);

                        R++;
                      }
                      myReader.close();
                 } catch (FileNotFoundException e1) {
                      e1.printStackTrace();
                 }
  
            }
        });

        // #7-9
        btn34.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (FileWriter reportWriter = new FileWriter("c:/temp/R01_2018E7196.txt")) {
                    // 헤더 출력
                    reportWriter.write("학번\t이름\t전공\t교양\t합계\t평균\t등급\t석차\t과목별평균\n");

                    // 데이터 출력
                    for (int R = 0; R < table1.getRowCount(); R++) {
                        int total = 0;
                        for (int C = 0; C < table1.getColumnCount(); C++) {
                            reportWriter.write(table1.getValueAt(R, C) + "\t");

                            
                        }

                        reportWriter.write("\n");
                    }
                    reportWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // #7-10
        btn36.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 테이블의 데이터를 저장할 리스트 생성
                List<String[]> tableData = new ArrayList<>();

                // 테이블의 데이터를 리스트에 추가
                for (int R = 0; R < table1.getRowCount(); R++) {
                    String[] rowData = new String[table1.getColumnCount()];
                    for (int C = 0; C < table1.getColumnCount(); C++) {
                        rowData[C] = table1.getValueAt(R, C).toString();
                    }
                    tableData.add(rowData);
                }

                // 리스트를 이름으로 정렬
                Collections.sort(tableData, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] row1, String[] row2) {
                        return row1[1].compareTo(row2[1]); // 이름으로 정렬
                    }
                });

                // 파일에 정렬된 데이터 쓰기
                try (FileWriter sortedWriter = new FileWriter("c:/temp/R02_2018E7196.txt")) {
                    // 헤더 출력
                    sortedWriter.write("학번\t이름\t전공\t교양\t합계\t평균\t등급\t석차\t과목별평균\n");

                    // 정렬된 데이터 출력
                    for (String[] rowData : tableData) {
                        for (String data : rowData) {
                            sortedWriter.write(data + "\t");
                        }
                        sortedWriter.write("\n");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btn37.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try (FileWriter myWriter = new FileWriter("c:/temp/R03_2018E7196.html")) {
          
                myWriter.write("<!DOCTYPE html>\n");
                myWriter.write("<HTML><HEAD> \n");
                myWriter.write("<TITLE>최동혁(2018E7196)의 성적표.HTML</TITLE> \n");
                myWriter.write("<STYLE> \n");
                myWriter.write("table {border-collapse: collapse; text-align: center; width: 500px; } \n");
                myWriter.write("table tr:hover {background-color: lightgreen; height:40px;} \n");
                myWriter.write("</STYLE></HEAD><BODY> \n");
                myWriter.write("<DIV align=center><H2>최동혁(2018E7196)의 성적표 만들기(HTML)</H2></DIV> \n");
                myWriter.write("<TABLE border=1 align=center> \n");
                myWriter.write("<THEAD> \n");
                myWriter.write("<TR><TH>학번</TH><TH>이름</TH><TH>전공</TH><TH>교양</TH><TH>합계</TH><TH>평가</TH><TH>등급</TH><TH>석차</TH><TH>과목별평균</TH></TR> \n");
                myWriter.write("</THEAD><TBODY> \n");
                          
                for (int R = 0; R < table1.getRowCount(); R++) {
                  myWriter.write(String.format("<TR><TD>%10s", table1.getValueAt(R, 0)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 1)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 2)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 3)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 4)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 5)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 6)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 7)) + " ");
                  myWriter.write(String.format("</TD><TD>%3s", table1.getValueAt(R, 8)) + " ");
                  
                  myWriter.write("</TD><TR>\n");
                }
          
                myWriter.write( "</TBODY> \n");
                myWriter.write( "</TABLE> \n");
                myWriter.write( "</BODY> \n");
                myWriter.write( "</HTML> \n");
                          
                myWriter.close();
              } catch (IOException e1) {
              e1.printStackTrace();
              }
            }
          });

        // #7-11
        btn38.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 테이블의 데이터를 저장할 리스트 생성
                List<String[]> tableData = new ArrayList<>();

                // 테이블의 데이터를 리스트에 추가
                for (int R = 0; R < table1.getRowCount(); R++) {
                    String[] rowData = new String[table1.getColumnCount()];
                    for (int C = 0; C < table1.getColumnCount(); C++) {
                        rowData[C] = table1.getValueAt(R, C).toString();
                    }
                    tableData.add(rowData);
                }

                // 리스트를 CSV 파일에 쓰기
                try (FileWriter csvWriter = new FileWriter("c:/temp/R04_2018E7196.csv")) {
                    // 헤더 출력
                    csvWriter.write("학번,이름,전공,교양,합계,평균,등급,석차,과목별평균\n");

                    // 데이터 출력
                    for (String[] rowData : tableData) {
                        for (String data : rowData) {
                            csvWriter.write(data + ",");
                        }
                        csvWriter.write("\n");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnSIDSEARCH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchValue = txtSIDSEARCH.getText();
                
                // 테이블을 순회하면서 학번이 일치하는 행을 찾음
                for (int row = 0; row < table1.getRowCount(); row++) {
                    String studentID = (String) table1.getValueAt(row, 0); // 학번 열의 데이터 가져오기
        
                    if (studentID.equals(searchValue)) {
                        // 해당 학번을 가진 행을 찾았을 때, 해당 행으로 스크롤하고 강조
                        table1.setRowSelectionInterval(row, row);
                        table1.scrollRectToVisible(table1.getCellRect(row, 0, true));
                        return; // 학번이 중복되지 않는다고 가정하면 검색 종료
                    }
                }
        
                // 학번이 없는 경우 메시지 또는 작업 수행
                JOptionPane.showMessageDialog(myGUI4, "해당 학번을 찾을 수 없습니다.", "검색 결과", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnSNAMESEARCH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchValue = txtSNAMESEARCH.getText();
                
                // 테이블을 순회하면서 학번이 일치하는 행을 찾음
                for (int row = 0; row < table1.getRowCount(); row++) {
                    String studentNAME = (String) table1.getValueAt(row, 1); // 학번 열의 데이터 가져오기
        
                    if (studentNAME.equals(searchValue)) {
                        // 해당 학번을 가진 행을 찾았을 때, 해당 행으로 스크롤하고 강조
                        table1.setRowSelectionInterval(row, row);
                        table1.scrollRectToVisible(table1.getCellRect(row, 1, true));
                        return; // 학번이 중복되지 않는다고 가정하면 검색 종료
                    }
                }
        
                // 학번이 없는 경우 메시지 또는 작업 수행
                JOptionPane.showMessageDialog(myGUI4, "해당 이름을 찾을 수 없습니다.", "검색 결과", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // btn39 ActionListener에 추가
        btn39.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myGUI3.showBarChart();
            }
        });
        

        myGUI4.setVisible(true);
    }

    // 등급 계산 함수
        private static String calculateGrade(double average) {
            if (average >= 90) {
                return "A";
            } else if (average >= 80) {
                return "B";
            } else if (average >= 70) {
                return "C";
            } else if (average >= 60) {
                return "D";
            } else {
                return "F";
            }
        }

        // 새로운 메소드 추가
        private static void showBarChart() {
            // 그래프 데이터 생성
            CategoryDataset dataset = createDataset();

            // 그래프 생성
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Average score Bar Graph-2018E7196", // 그래프 제목
                    "Student NAME",          // X 축 레이블
                    "average",               // Y 축 레이블
                    dataset,             // 데이터셋
                    PlotOrientation.VERTICAL,
                    true, true, false);

            // 그래프를 그릴 패널 생성
            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

            // 새로운 프레임에 패널 추가 및 표시
            JFrame chartFrame = new JFrame("Average score Bar Graph-2018E7196");
            chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            chartFrame.getContentPane().add(chartPanel);
            chartFrame.pack();
            chartFrame.setLocationRelativeTo(null);
            chartFrame.setVisible(true);
        }

        private static double getDoubleValue(Object value) {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            } else {
                // 기본적으로는 0.0으로 처리하거나, 다른 적절한 기본값을 사용할 수 있습니다.
                return 0.0;
            }
        }

        // 데이터셋 생성 메소드
        private static CategoryDataset createDataset() {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
            // 테이블에서 이름과 평균 가져와서 데이터셋에 추가
            for (int R = 0; R < table1.getRowCount(); R++) {
                String name = (String) table1.getValueAt(R, 1);
                double average = getDoubleValue(table1.getValueAt(R, 5)); // 5는 평균 열의 인덱스, 필요에 따라 수정
        
                dataset.addValue(average, "average", name);
            }
        
            return dataset;
        }

        // 석차 계산 메서드
        private static void calculateRank() {
            int rowCount = table1.getRowCount();
            int[] ranks = new int[rowCount];

            for (int i = 0; i < rowCount; i++) {
                double currentAverage = getDoubleValue(table1.getValueAt(i, 5));
                ranks[i] = 1; // 초기값은 1로 설정

                for (int j = 0; j < rowCount; j++) {
                    if (i != j) {
                        double otherAverage = getDoubleValue(table1.getValueAt(j, 5));

                        // 현재 학생의 평균보다 다른 학생의 평균이 높으면 석차 증가
                        if (otherAverage > currentAverage) {
                            ranks[i]++;
                        }
                    }
                }
            }

            // 석차를 테이블에 업데이트
            for (int i = 0; i < rowCount; i++) {
                table1.setValueAt(ranks[i], i, 7);
            }
        }

        // 학번을 이용하여 석차 가져오기
        private static int getRank(int studentID) {
            int rowCount = table1.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                int currentID = Integer.parseInt(table1.getValueAt(i, 0).toString());
                if (currentID == studentID) {
                    return Integer.parseInt(table1.getValueAt(i, 7).toString());
                }
            }
            return -1; // 학번이 없으면 -1 반환
        }
     
}
