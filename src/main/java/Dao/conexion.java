package com.ecumarket.dao;


            @Override
            public void run() {
                try {
                    if (con != null && !con.isClosed()) {
                        Statement stmt = con.createStatement();
                        stmt.executeQuery("SELECT 1");
                        stmt.close();
                        System.out.println("📶 Ping enviado para mantener la conexión activa.");
                    }
                } catch (SQLException e) {
                    System.out.println("⚠️ Error de ping: " + e.getMessage());
                }
            }
        }, 0, 240000);
    }
}
    
    */

    
    
    





